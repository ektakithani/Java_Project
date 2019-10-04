import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.*;
class Music{
public void playSuccess(){
try{
AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File("success.wav").getAbsoluteFile());
Clip clip=AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
}
catch(Exception e){
System.out.println("Music playing issues");
}
}
public void playFailure(){
try{
AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File("failure.wav").getAbsoluteFile());
Clip clip=AudioSystem.getClip();
clip.open(audioInputStream);
clip.start();
}
catch(Exception e){
System.out.println("Music playing issues");
}
}
}