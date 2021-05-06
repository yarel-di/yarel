
module BitStack{
	dcl bitpush {5 int}
	def bitpush := // s b 0 0 0
		/3 1 4 5 2/ // 0 s 0 0 b
		; for[ inc; inc ] | id | id | id // 2s s 0 0 b
		; (
			// 2s s 0 0
			id | id | inc | id 
			; /2 4 3 1/ // s 0 1 2s
			; for [ // sets the first register to 0 by "halving" the 4-th
				if[ dec|id, id|id, id|id]
				; /1 3 2/
			] // 0 0 1 2s 
		) | id // 0 0 1 2s b
		; id|id|id| if[ inc, id, id] // 0 0 1 (2s+b) b
		; /1 5 2 3 4/ // 0 b 0 1 ()
		; id|id| for[/2 1/] // 0 b odd even ()
		; id| if[dec, id, id] |id|id // 0 0 odd even ()
		; id|id| for[/2 1/] // 0 0 0 1 ()
		; id|id|id| dec |id	// 0^4 ()
		; /5 2 3 4 1/ // () 0^4
		
	dcl bitpop{5 int}
	def bitpop:= inv[bitpush]
} 