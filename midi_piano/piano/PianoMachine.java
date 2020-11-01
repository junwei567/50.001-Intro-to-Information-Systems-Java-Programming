package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;
import music.NoteEvent;
import java.util.ArrayList;

public class PianoMachine {
	
	private Midi midi;
    private ArrayList<Pitch> pitches = new ArrayList<Pitch>();
    private Instrument instrument = Instrument.PIANO;
    private int octaves = 0;
    private boolean record = false;
    private ArrayList<NoteEvent> noteEventArrayList = new ArrayList<NoteEvent>();
    private long time = 0;

    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }
    
    public void beginNote(Pitch rawPitch) {
        if (!pitches.contains(rawPitch)) {
            if (record) {
                noteEventArrayList.add(new NoteEvent(rawPitch,
                        System.currentTimeMillis(),
                        instrument,
                        NoteEvent.Kind.start));
            }
            pitches.add(rawPitch.transpose(octaves*12));
            midi.beginNote( rawPitch.transpose(octaves*12).toMidiFrequency(), instrument);
        }
    }

    public void endNote(Pitch rawPitch) {
        if (pitches.contains(rawPitch)) {
            midi.endNote( rawPitch.transpose(octaves*12).toMidiFrequency(),instrument);
            pitches.remove(rawPitch.transpose(octaves*12));
            if (record) {
                noteEventArrayList.add(new NoteEvent(rawPitch,
                        System.currentTimeMillis(),
                        instrument,
                        NoteEvent.Kind.stop));
            }
        }
    }
    
    public void changeInstrument() {
        instrument = instrument.next();
    }
    
    public void shiftUp() {
        if (octaves < 2) octaves ++;
    }
    
    public void shiftDown() {
        if (octaves > -2) octaves --;
    }
    
    public boolean toggleRecording() {
        if (record) record = false;
        else {
            noteEventArrayList.clear();
            record = true;
            time = 0;
        }
        return record;
    }
    
    public void playback() {
        for (NoteEvent note: noteEventArrayList) {
            if ((time != 0) && (note.getTime() - time > 5)) {
                Midi.rest((int)(note.getTime() - time)/10);
            }
            time = note.getTime();
            if (note.getKind() == NoteEvent.Kind.start) {
                midi.beginNote(note.getPitch().toMidiFrequency(), note.getInstr());
            } else if (note.getKind() == NoteEvent.Kind.stop) {
                midi.endNote(note.getPitch().toMidiFrequency(), note.getInstr());
            }
        }
    }

}

