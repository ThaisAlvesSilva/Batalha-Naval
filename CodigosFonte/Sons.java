package CodigosFonte;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sons{
	public void playSound(String nome) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Clip som = AudioSystem.getClip();
	    AudioInputStream oStream = AudioSystem.getAudioInputStream(new File(nome).getAbsoluteFile());
	    som.open(oStream);

	    som.loop(0);
	}
}
