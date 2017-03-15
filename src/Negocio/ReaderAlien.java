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
public class ReaderAlien implements MessageListener{
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
  reader.setPersistTime(10080);
  reader.setAutoAction("Acquire");
  reader.setAutoStartTrigger("0, 0");
  reader.setAutoStopTimer(0);
  reader.setAutoTrueOutput(1);
  reader.setAutoTruePause(500);
  reader.setAutoFalseOutput(2);
  reader.setAutoFalsePause(500);
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
  } while(service.isRunning()&&banStop==false);
   service.stopService();
 }

    @Override
    public void messageReceived(Message message) {
        String val="";
    if (message.getTagCount() == 0) {
     } else {  
        for(int i=0;i< message.getTagCount();i++){
           creatTags(message.getTag(i).getTagID());
                }
            }
        }




    public void creatTags(String ID){
            TagsNeg tagne=new TagsNeg(new Tag(ID), 1);
            tags.add(tagne);
    }
    
    public ArrayList<TagsNeg> getListTags(){
        return tags;
    }

    public void clearTags(){
    tags.clear();
    }
    
    public void setStop(boolean stop){
    banStop=stop;
    }
    
}
    
   
    
    
    


