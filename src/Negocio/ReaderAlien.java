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
import Negocio.TagsNeg;
import java.util.ArrayList;
/**
 *
 * @author PERSONAL
 */
public class ReaderAlien  extends Thread implements MessageListener{
   // poder eescoher
   private AlienClass1Reader reader;
   private static String SOCKET="192.168.1.100";
   private ArrayList<TagsNeg> tags=new ArrayList();
   boolean banStop= false;
   
  
   
    
    
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
    
    
    public void ListenerTags() throws Exception{
  MessageListenerService service = new MessageListenerService(8080);
  service.setMessageListener(this);
  service.startService();
  if(!reader.isOpen()){
        reader.setNetworkConnection(SOCKET,23);
        reader.setUsername("alien");
        reader.setPassword("password");
  }
  reader.open();
  reader.autoModeReset();
  reader.clearTagList();
  reader.setPersistTime(30);
  reader.setAutoAction("Acquire");
  reader.setAutoStartTrigger("0, 0");
  reader.setAutoStopTimer(0);
  reader.setAutoTrueOutput(1);
  reader.setAutoTruePause(200);
  reader.setAutoFalseOutput(2);
  reader.setAutoFalsePause(200);
  reader.setNotifyAddress(InetAddress.getLocalHost().getHostAddress(), service.getListenerPort());
  reader.setNotifyFormat(AlienClass1Reader.XML_FORMAT); // Make sure service can decode it.
  reader.setNotifyTrigger("Add"); // Notify whether there's a tag or not
  reader.setNotifyMode(AlienClass1Reader.ON);
  reader.setAutoMode(AlienClass1Reader.ON);
  reader.close();
  do {
    Thread.sleep(2000);
  } while(service.isRunning());
   service.stopService();
 }

    @Override
    public void messageReceived(Message message) {
        String val="";
    if (message.getTagCount() == 0) {
        //System.out.println("(No Taga)");
     } else {
        for(int i=0;i< message.getTagCount();i++){
            System.out.println(message.getTag(i).toLongString());
           creatTags(message.getTag(i).getTagID());
                }
            }
    }




    public void creatTags(String ID){
        synchronized(tags){
            TagsNeg tagne=new TagsNeg(new Tag(ID), 1);
            tags.add(tagne);
        }
    }
    
    public  ArrayList<TagsNeg> getListTags(){
        synchronized(tags){
        return tags;
        }
    }

    public void clearTags(){
        synchronized(tags){
        tags.clear();
        }
    }
    
    public void setStop(boolean stop){
    banStop=stop;
    }

  

    
     
    @Override
    public void run() {
        try{
        ListenerTags();
        }catch( Exception ex){
        ex.printStackTrace();
        }
    }
    
    
    
}
    
   
    
    
    


