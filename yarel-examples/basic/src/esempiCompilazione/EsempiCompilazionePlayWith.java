package esempiCompilazione;
import yarelcore.*;
import java.util.Arrays;

public class EsempiCompilazionePlayWith {
	public static void main(String[] args) throws Exception {
		 RPP fRPP = new esempiCompilazione.F();
		 for(int i : fRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
