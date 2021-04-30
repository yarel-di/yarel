
module BitStack{
	dcl bitpush {5 int}
	def bitpush := // s b 0 0 0
		/3 1 4 5 2/ // 0 s 0 0 b
		; for[ inc; inc ] | id | id | id // 2s s 0 0 b
		; (
			// 2x x 0 0
			id | id | inc | id 
			; /2 4 3 1/ // X 0 1 2x
			; for [ // halving the first register
				if[ dec|id, id|id, id|id]
				; /1 3 2/
			] // 0 0 1 2x
			; /4 1 3 2/ // 2x 0 1 0
			; id|id|dec|id // 2x 0^3
		) | id // 2s 0 0) 0 b
		; if[
			inc|inc|id|id,
			id|inc|id|id,
			id|inc |id|id
		] //(2s+b) 1 0 0 b
		; /4 5 3 2 1/ // 0 b 0 1 ()
		; id|id| for[/2 1/] // 0 b odd even ()
		; id| if[dec, id, id] |id|id // 0 0 odd even ()
		; id|id| for[/2 1/] // 0 0 0 1 ()
		; id|id|id| dec |id	// 0^4 ()
		; /5 2 3 4 1/ // () 0^4
		
	dcl bitpop{5 int}
	def bitpop:= inv[bitpush]
}