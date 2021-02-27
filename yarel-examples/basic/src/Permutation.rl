module permuatation {
	dcl pExample : 4 int
	def pExample := /3 4 1 2/
	
	dcl pInd_dataset : 4 int
	def pInd_dataset :=
		id| (dec;dec;dec) | (inc;inc)|inc 
	
	/* indexes in both name and registers are meant as
	 * Yarel does: arrays are 1-based
	 */
	
	dcl pIndexed_1 : 5 int
	def pIndexed_1 :=
		pInd_dataset| (inc); 
		/ {4} /
	
	dcl pIndexed_2 : 5 int
	def pIndexed_2 :=
		pInd_dataset| (inc;inc);
		/ {4} /
	
	dcl pIndexed_3 : 5 int
	def pIndexed_3 :=
		pInd_dataset| (inc;inc;inc);
		/ {4} /

	dcl pIndexed_4 : 5 int
	def pIndexed_4 :=
		pInd_dataset| (inc;inc;inc;inc);
		/ {4} /
 
	dcl pIndexed_5 : 5 int
	def pIndexed_5 :=
		pInd_dataset| (inc;inc;inc;inc;inc);
		/ {4} /
	
	dcl pIndexed_6 : 5 int
	def pIndexed_6 :=
		pInd_dataset| (inc;inc;inc;inc;inc;inc);
		/ {4} /
	
	dcl pIndexed_8 : 5 int
	def pIndexed_8 :=
		pInd_dataset | 
			(inc;inc;inc;inc;inc;
				inc;inc;inc
			);
		/ {4} /
		
	dcl pIndexed_7 : 5 int
	def pIndexed_7 :=
		pInd_dataset | 
			(inc;inc;inc;inc;inc;
				inc;inc
			);
		/ {4} /
		
	dcl pIndexed_10 : 5 int
	def pIndexed_10 :=
		pInd_dataset| 
			(inc;inc;inc;inc;inc;
				inc;inc;inc;inc;inc
			);
		/ {4} /
		
	dcl pIndexed_12 : 5 int
	def pIndexed_12 :=
		pInd_dataset| (inc;inc ;inc;inc;inc;inc;inc;inc;inc;inc;inc;inc);
		/ {4} /
			
	dcl pIndexed_min_14 : 5 int
	def pIndexed_min_14 :=
		pInd_dataset| inv[inc;inc ;inc;inc;inc;inc;inc;inc;inc;inc;inc;inc;inc;inc];
		/ {4} /
		
	dcl pIndexed_min_11 : 5 int
	def pIndexed_min_11 :=
		pInd_dataset|
		 inv[inc;inc;inc;inc;inc;inc;inc;inc;inc;inc;inc];
		/ {4} /
	
	dcl pIndexed_min_1 : 5 int
	def pIndexed_min_1 :=
		pInd_dataset | dec;
		/ {4} /


//


//	dcl shiftLeft10IntsArray1Place : 13 int //return: 0 L(ength) int[10] 0
//	def shiftLeft10IntsArray1Place :=               // 0 0 L(ength) a:=int[10]
//		id|for[inc]|id|id|id|id|id|id|id|id|id|id   // 0 L L a
//		;/2 1/|id|id|id|id|id|id|id|id|id|id|id     // L 0 
//		;/{12}/                                 // L a[L] a[1..L-1] L
//		
//		// L 0 a L
//		// L-2 0 a[L-1] L-1
//		;for[
//			inc| id|id|id|id|id|id|id|id|id|id|id
//			;/{11}/
//		] //0 a[L] a[1..L-1] L
//		;id|id|id|id|id|id|id|id|id|id|id|dec // 0 a[L] a[1..L-1] L-1
//		(for[inc];
//		inc|id
//			)|id|id|id|id|id|id|id|id|id|id // L+1 L a
//		;/{11}/ // L+1 a[L] a[1..L-1] L // "a[L-1]" if 
//		;it[/{11}/
//			;id|id|id|id|id|id|id|id|id|id|id|dec
//		]

		// /1 4 5 6 7 8 9 10 11 12 13 2 3/
//	dcl shiftLeft10IntsArray1Place : 13 int // return: 0 L(ength) a:=int[10] 0
//	def shiftLeft10IntsArray1Place :=               // 0 0 L(ength) a:=int[10]
//		id|for[inc]|id|id|id|id|id|id|id|id|id|id   // 0 L L a
//		;/2 1/|id|id|id|id|id|id|id|id|id|id|id     // L 0 
//		;/{12}/                                 // L a[L] a[1..L-1] L
}