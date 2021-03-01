package org.di.unito.yarel.utils

import java.util.Map
import java.util.TreeMap
import java.util.LinkedHashMap

/**
 * A mutable object modeling an operator's arity,
 * composed by an optional constant part (a scalar)
 * and a set of named parameters.
 */
class ComposedArity {
	protected var int scalar;
	protected var Map<String, Integer> parametersCoefficients;
	
	new(int scalar){
		this.scalar = scalar
		this.parametersCoefficients = new TreeMap<String,Integer>(Utils.STRING_COMPARATOR);
	}
	new(){
		this(0);
	}
	
	def int getScalar(){
		return this.scalar;
	}

	def Map<String,Integer> getParametersCoefficients(){
		return this.parametersCoefficients;
	}
	
	def boolean isParametric(){
		return !this.parametersCoefficients.empty;
	}
	
	def int getParametersAmount(){
		return this.parametersCoefficients.size;
	}
	
	def ComposedArity addScalar(int value){
		this.scalar += value;
		return this;
	}
	
	def ComposedArity removeScalar(int value){
		this.scalar -= value;
		return this;
	}
	
	def ComposedArity setScalar(int value){
		this.scalar = value;
		return this;
	}
	
	def ComposedArity addParameterCoefficient(String parameterName, int value){
		if(value == 0) return this;
		if(this.parametersCoefficients.containsKey(parameterName)){
			val int oldCoeff = this.parametersCoefficients.get(parameterName);
			val int newCoeff = oldCoeff + value;
			this.parametersCoefficients.remove(parameterName);
			if(newCoeff != 0){
				this.parametersCoefficients.put(parameterName, newCoeff);
			}
		}else{
			this.parametersCoefficients.put(parameterName, value);
		}
		return this;
	}
	def ComposedArity addParameterCoefficient(String parameterName){
		this.addParameterCoefficient(parameterName, 1);
	}
	
	def ComposedArity subParameterCoefficient(String parameterName, int value){
		return addParameterCoefficient(parameterName, -value);
	}
	def ComposedArity subParameterCoefficient(String parameterName){
		this.subParameterCoefficient(parameterName, 1);
	}
	
	def ComposedArity removeParameterCoefficient(String parameterName){
		if(this.parametersCoefficients.containsKey(parameterName)){
			this.parametersCoefficients.remove(parameterName);
		}
		return this;
	}
	
	/**
	 * Sum the current composed arity with a given one, altering the current one,
	 * and returns the current one.
	 * <p>
	 * NOTE: since this method alters the current stored values, it's advised to
	 * invoke {@link #clone()} to preserve the current composed arity from being
	 * altered by the addition. (That means that the instance obtained at the end is
	 * different from the original ones).<br>
	 * An example:
	 * <pre>
	 * <code>
	 * ComposedArity aCompAr = ....
	 * ComposedArity anotherCompAr = ...
	 * ComposedArity sumCA =
	 * 		aCompAr.clone().sum(anotherCompAr);
	 * assert aCompAr != sumCA;
	 * </code>
	 * </pre>
	 * 
	 * @return the current composed arity, after the alteration
	 */
	def ComposedArity sum(ComposedArity ca){
		if(ca == this){
			this.scalar += this.scalar;
			val Map<String,Integer> copyPar = new LinkedHashMap();
			parametersCoefficients.forEach[String parName, int parValue|
				copyPar.put(parName, parValue)
			];
			parametersCoefficients.clear
			copyPar.forEach[String parName, int parValue|
				parametersCoefficients.put(parName, parValue+parValue)
			]
			return this;
		}
		val ComposedArity thisInstance = this
		this.scalar += ca.scalar 
		ca.parametersCoefficients.forEach[String parName, int parValue|
			thisInstance.addParameterCoefficient(parName, parValue)
		]
		return this;
	}
	
	def ComposedArity subtract(ComposedArity ca){
		if(ca == this){
			this.scalar = 0;
			parametersCoefficients.clear
			return this;
		}
		val ComposedArity thisInstance = this
		this.scalar -= ca.scalar 
		ca.parametersCoefficients.forEach[String parName, int parValue|
			thisInstance.addParameterCoefficient(parName, -parValue)
		]
		return this;
	}
	
	/**
	 * See {@link Object#clone()}.
	 */
	override ComposedArity clone( ){
		val ComposedArity newCa = new ComposedArity();
		newCa.scalar = this.scalar
		this.parametersCoefficients.forEach[String parName, int parValue|
			newCa.addParameterCoefficient(parName, parValue)
		]
		return newCa;
	}
	
	override String toString(){
		return
		'''«this.scalar»«IF this.parametersCoefficients.size > 0» + «FOR coeff: this.parametersCoefficients.entrySet SEPARATOR " + "»(«IF coeff.value >= 0»«coeff.value»«ELSE»(-«Math.abs(coeff.value)»)«ENDIF»*«coeff.key»)«ENDFOR»«ENDIF»'''
	}
	
	override boolean equals(Object o){
		var ComposedArity ca;
		if(o === null) return false;
		if(o === this) return true;
		if(!(o instanceof ComposedArity)) return false;
		ca = o as ComposedArity;
		if(ca.scalar != this.scalar) return false;
		if(ca.parametersCoefficients.size != this.parametersCoefficients.size) return false;
		val thisParamCoeffIterator = this.parametersCoefficients.entrySet.iterator;
		val caParamCoeffIterator = ca.parametersCoefficients.entrySet.iterator;
		while(thisParamCoeffIterator.hasNext){
			val param = thisParamCoeffIterator.next;
			if(ca.parametersCoefficients.containsKey(param.key)){
				if(!ca.parametersCoefficients.get(param.key).equals(param.value)){
					return false;
				}
			}else{
				return false;
			}
		}
		while(caParamCoeffIterator.hasNext){
			val param = caParamCoeffIterator.next;
			if(this.parametersCoefficients.containsKey(param.key)){
				if(!this.parametersCoefficients.get(param.key).equals(param.value)){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
}