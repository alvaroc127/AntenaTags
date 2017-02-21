/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import com.alien.enterpriseRFID.notify.Message;
import com.alien.enterpriseRFID.notify.MessageListener;
import com.alien.enterpriseRFID.notify.MessageListenerService;
import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author PERSONAL
 */
public class ReaderAlien implements MessageListener{
    
   private AlienClass1Reader reader;
   private static String SOCKET="192.168.1.100";
   private boolean medOk=false;
   private ArrayList cont=new ArrayList();
   private Map<String, Integer> clavVal= new HashMap<String, Integer>();
   private Map<Integer,String> valClav= new HashMap<Integer,String>();
   private int conttt=0;
   
    
    
    public Tag[] readAlien() throws AlienReaderException{
        reader.setNetworkConnection(SOCKET,23);
        reader.setUsername("alien");
        reader.setPassword("password");
        reader.open();
        Tag[] tagsReads = reader.getTagList();
        reader.close();
        if(tagsReads == null){
        return null;
        }else{
        return tagsReads;
        }
    }
    
    public ReaderAlien(){
    reader =new AlienClass1Reader();
    }
    
    
    public String ListenerTags() throws Exception{
  MessageListenerService service = new MessageListenerService(4665);
  service.setMessageListener(this);
  service.startService();
  if(!reader.isOpen()){
 reader.setNetworkConnection(SOCKET,23);
        reader.setUsername("alien");
        reader.setPassword("password");
  }
  reader.open();
  

 
  reader.clearTagList();
  reader.setAutoAction("Acquire");
  reader.setAutoStartTrigger("0, 0");
  reader.setAutoStopTimer(100);
  reader.setAutoTruePause(0);
  reader.setAutoFalsePause(100);
  reader.setNotifyAddress(InetAddress.getLocalHost().getHostAddress(), service.getListenerPort());
  reader.setNotifyFormat(AlienClass1Reader.XML_FORMAT); // Make sure service can decode it.
  reader.setNotifyTrigger("Add"); // Notify whether there's a tag or not
  reader.setNotifyMode(AlienClass1Reader.ON);

  
  reader.setAutoMode(AlienClass1Reader.ON);
  reader.close();
  
  long runTime = 10000; // milliseconds
  long startTime = System.currentTimeMillis();
  do {
    Thread.sleep(1000);
  } while(service.isRunning()&& medOk == false);
   String out=idMayRed(calMedi());
   clavVal.clear();
   cont.clear();
   valClav.clear();
   service.stopService();
   return  out;
 }

    @Override
    public void messageReceived(Message message) {
        String val="";
    if (message.getTagCount() == 0) {
     } else {
        if(conttt==0){
                val=message.getTag(0).getTagID();
            }
        if(conttt==100){
            medOk=true;
            conttt=0;
        }else{
        conttt++;
        for(int i=0;i< message.getTagCount();i++){
           val=cuenta(message.getTag(i).getTagID(),val);
                }
            }
        }
    }
    
    public String cuenta(String ID,String com){
        int cont1=0;
        int indice=0;
        if(!cont.isEmpty()){
          indice = cont.size()-1;
        }
        if(clavVal.isEmpty()){
            clavVal.put(ID, 0);
            valClav.put(0,ID);
        }else{
            if(clavVal.containsKey(ID)){
            indice=clavVal.get(ID);
            com=ID;
            }else{
                clavVal.put(ID, indice++);
                valClav.put(indice,ID);
            }
        }
        if(cont.isEmpty()){
        cont.add(1);
        }else{
            if(com.equals(ID)){
           cont1=(int) cont.get(indice);
                System.out.println(ID + " + " + cont1);
            cont.set(indice, ++cont1);
            }else{
            com = ID;
            cont.add(1);
            }
        }
        return com;
    }
    
    
    
    public int calMedi(){
        int may=(int)cont.get(0);
        int indice=0;
        for(int i =0 ; i< cont.size();i++){
            if(may <(int) cont.get(i)){
                may = (int)cont.get(i);
                indice=i;
            }
        }
         System.out.print("entro o no entro pero el indice y may es :"+ may +" "+indice);
        return indice;
    }
    
    public String idMayRed(int indice) {
        return this.valClav.get(indice);
    }
    
}
