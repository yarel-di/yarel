module permuatation {
	dcl pExample : 4 int
	def pExample := /3 4 1 2/
	
	dcl pInd_dataset : 4 int
	def pInd_dataset :=
		id| (dec;dec;dec) | (inc;inc)|inc 
	
	dcl pIndexed_0 : 5 int
	def pIndexed_0 :=
		pInd_dataset| id;
		/ {4} /
	
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

}