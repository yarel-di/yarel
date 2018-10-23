/*
 * generated by Xtext 2.15.0
 */
grammar InternalYarel;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.di.unito.yarel.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.di.unito.yarel.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.di.unito.yarel.services.YarelGrammarAccess;

}

@parser::members {

 	private YarelGrammarAccess grammarAccess;

    public InternalYarelParser(TokenStream input, YarelGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected YarelGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='module'
		{
			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModuleKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_3_0());
				}
				lv_elements_3_0=ruleElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"elements",
						lv_elements_3_0,
						"org.di.unito.yarel.Yarel.Element");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleElement
entryRuleElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElementRule()); }
	iv_ruleElement=ruleElement
	{ $current=$iv_ruleElement.current; }
	EOF;

// Rule Element
ruleElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getElementAccess().getImportParserRuleCall_0());
		}
		this_Import_0=ruleImport
		{
			$current = $this_Import_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getElementAccess().getDeclarationParserRuleCall_1());
		}
		this_Declaration_1=ruleDeclaration
		{
			$current = $this_Declaration_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getElementAccess().getDefinitionParserRuleCall_2());
		}
		this_Definition_2=ruleDefinition
		{
			$current = $this_Definition_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	iv_ruleImport=ruleImport
	{ $current=$iv_ruleImport.current; }
	EOF;

// Rule Import
ruleImport returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='import'
		{
			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0());
				}
				lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getImportRule());
					}
					set(
						$current,
						"importedNamespace",
						lv_importedNamespace_1_0,
						"org.di.unito.yarel.Yarel.QualifiedNameWithWildcard");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); }
	iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard
	{ $current=$iv_ruleQualifiedNameWithWildcard.current.getText(); }
	EOF;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
		}
		this_QualifiedName_0=ruleQualifiedName
		{
			$current.merge(this_QualifiedName_0);
		}
		{
			afterParserOrEnumRuleCall();
		}
		(
			kw='.*'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1());
			}
		)?
	)
;

// Entry rule entryRuleDeclaration
entryRuleDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeclarationRule()); }
	iv_ruleDeclaration=ruleDeclaration
	{ $current=$iv_ruleDeclaration.current; }
	EOF;

// Rule Declaration
ruleDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='dec'
		{
			newLeafNode(otherlv_0, grammarAccess.getDeclarationAccess().getDecKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getDeclarationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeclarationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclarationAccess().getSignatureSignatureParserRuleCall_3_0());
				}
				lv_signature_3_0=ruleSignature
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclarationRule());
					}
					set(
						$current,
						"signature",
						lv_signature_3_0,
						"org.di.unito.yarel.Yarel.Signature");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSignature
entryRuleSignature returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignatureRule()); }
	iv_ruleSignature=ruleSignature
	{ $current=$iv_ruleSignature.current; }
	EOF;

// Rule Signature
ruleSignature returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSignatureAccess().getTypesTypeParserRuleCall_0_0());
				}
				lv_types_0_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignatureRule());
					}
					add(
						$current,
						"types",
						lv_types_0_0,
						"org.di.unito.yarel.Yarel.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=','
			{
				newLeafNode(otherlv_1, grammarAccess.getSignatureAccess().getCommaKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSignatureAccess().getTypesTypeParserRuleCall_1_1_0());
					}
					lv_types_2_0=ruleType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSignatureRule());
						}
						add(
							$current,
							"types",
							lv_types_2_0,
							"org.di.unito.yarel.Yarel.Type");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTypeAccess().getTypeAction_0(),
					$current);
			}
		)
		(
			(
				lv_value_1_0=RULE_INT
				{
					newLeafNode(lv_value_1_0, grammarAccess.getTypeAccess().getValueINTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)?
		otherlv_2='int'
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getIntKeyword_2());
		}
	)
;

// Entry rule entryRuleDefinition
entryRuleDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDefinitionRule()); }
	iv_ruleDefinition=ruleDefinition
	{ $current=$iv_ruleDefinition.current; }
	EOF;

// Rule Definition
ruleDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='def'
		{
			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDefinitionRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getDefinitionAccess().getDeclarationNameDeclarationCrossReference_1_0());
				}
			)
		)
		otherlv_2=':='
		{
			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getColonEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDefinitionAccess().getBodyBodyParserRuleCall_3_0());
				}
				lv_body_3_0=ruleBody
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDefinitionRule());
					}
					set(
						$current,
						"body",
						lv_body_3_0,
						"org.di.unito.yarel.Yarel.Body");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBody
entryRuleBody returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBodyRule()); }
	iv_ruleBody=ruleBody
	{ $current=$iv_ruleBody.current; }
	EOF;

// Rule Body
ruleBody returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getBodyAccess().getSerCompParserRuleCall());
	}
	this_SerComp_0=ruleSerComp
	{
		$current = $this_SerComp_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleSerComp
entryRuleSerComp returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSerCompRule()); }
	iv_ruleSerComp=ruleSerComp
	{ $current=$iv_ruleSerComp.current; }
	EOF;

// Rule SerComp
ruleSerComp returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSerCompAccess().getParCompParserRuleCall_0());
		}
		this_ParComp_0=ruleParComp
		{
			$current = $this_ParComp_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getSerCompAccess().getSerCompLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='.'
			{
				newLeafNode(otherlv_2, grammarAccess.getSerCompAccess().getFullStopKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSerCompAccess().getRightParCompParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleParComp
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSerCompRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.di.unito.yarel.Yarel.ParComp");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleParComp
entryRuleParComp returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getParCompRule()); }
	iv_ruleParComp=ruleParComp
	{ $current=$iv_ruleParComp.current; }
	EOF;

// Rule ParComp
ruleParComp returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getParCompAccess().getBodyBaseParserRuleCall_0());
		}
		this_BodyBase_0=ruleBodyBase
		{
			$current = $this_BodyBase_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getParCompAccess().getParCompLeftAction_1_0(),
						$current);
				}
			)
			otherlv_2='|'
			{
				newLeafNode(otherlv_2, grammarAccess.getParCompAccess().getVerticalLineKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getParCompAccess().getRightBodyBaseParserRuleCall_1_2_0());
					}
					lv_right_3_0=ruleBodyBase
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getParCompRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.di.unito.yarel.Yarel.BodyBase");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleBodyBase
entryRuleBodyBase returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBodyBaseRule()); }
	iv_ruleBodyBase=ruleBodyBase
	{ $current=$iv_ruleBodyBase.current; }
	EOF;

// Rule BodyBase
ruleBodyBase returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0='('
			{
				newLeafNode(otherlv_0, grammarAccess.getBodyBaseAccess().getLeftParenthesisKeyword_0_0());
			}
			{
				newCompositeNode(grammarAccess.getBodyBaseAccess().getBodyParserRuleCall_0_1());
			}
			this_Body_1=ruleBody
			{
				$current = $this_Body_1.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_2=')'
			{
				newLeafNode(otherlv_2, grammarAccess.getBodyBaseAccess().getRightParenthesisKeyword_0_2());
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getBodyBaseAccess().getAtomicParserRuleCall_1());
		}
		this_Atomic_3=ruleAtomic
		{
			$current = $this_Atomic_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAtomic
entryRuleAtomic returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAtomicRule()); }
	iv_ruleAtomic=ruleAtomic
	{ $current=$iv_ruleAtomic.current; }
	EOF;

// Rule Atomic
ruleAtomic returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyIdAction_0_0(),
						$current);
				}
			)
			(
				(
					lv_funName_1_0='id'
					{
						newLeafNode(lv_funName_1_0, grammarAccess.getAtomicAccess().getFunNameIdKeyword_0_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "funName", lv_funName_1_0, "id");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyIncAction_1_0(),
						$current);
				}
			)
			(
				(
					lv_funName_3_0='inc'
					{
						newLeafNode(lv_funName_3_0, grammarAccess.getAtomicAccess().getFunNameIncKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "funName", lv_funName_3_0, "inc");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyDecAction_2_0(),
						$current);
				}
			)
			(
				(
					lv_funName_5_0='dec'
					{
						newLeafNode(lv_funName_5_0, grammarAccess.getAtomicAccess().getFunNameDecKeyword_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "funName", lv_funName_5_0, "dec");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyNegAction_3_0(),
						$current);
				}
			)
			(
				(
					lv_funName_7_0='neg'
					{
						newLeafNode(lv_funName_7_0, grammarAccess.getAtomicAccess().getFunNameNegKeyword_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "funName", lv_funName_7_0, "neg");
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyInvAction_4_0(),
						$current);
				}
			)
			(
				(
					lv_function_9_0='inv'
					{
						newLeafNode(lv_function_9_0, grammarAccess.getAtomicAccess().getFunctionInvKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "function", lv_function_9_0, "inv");
					}
				)
			)
			otherlv_10='['
			{
				newLeafNode(otherlv_10, grammarAccess.getAtomicAccess().getLeftSquareBracketKeyword_4_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getBodyBodyParserRuleCall_4_3_0());
					}
					lv_body_11_0=ruleBody
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"body",
							lv_body_11_0,
							"org.di.unito.yarel.Yarel.Body");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_12=']'
			{
				newLeafNode(otherlv_12, grammarAccess.getAtomicAccess().getRightSquareBracketKeyword_4_4());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyItAction_5_0(),
						$current);
				}
			)
			(
				(
					lv_function_14_0='it'
					{
						newLeafNode(lv_function_14_0, grammarAccess.getAtomicAccess().getFunctionItKeyword_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "function", lv_function_14_0, "it");
					}
				)
			)
			otherlv_15='['
			{
				newLeafNode(otherlv_15, grammarAccess.getAtomicAccess().getLeftSquareBracketKeyword_5_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getBodyBodyParserRuleCall_5_3_0());
					}
					lv_body_16_0=ruleBody
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"body",
							lv_body_16_0,
							"org.di.unito.yarel.Yarel.Body");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_17=']'
			{
				newLeafNode(otherlv_17, grammarAccess.getAtomicAccess().getRightSquareBracketKeyword_5_4());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyIfAction_6_0(),
						$current);
				}
			)
			(
				(
					lv_function_19_0='if'
					{
						newLeafNode(lv_function_19_0, grammarAccess.getAtomicAccess().getFunctionIfKeyword_6_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
						setWithLastConsumed($current, "function", lv_function_19_0, "if");
					}
				)
			)
			otherlv_20='['
			{
				newLeafNode(otherlv_20, grammarAccess.getAtomicAccess().getLeftSquareBracketKeyword_6_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getPosBodyParserRuleCall_6_3_0());
					}
					lv_pos_21_0=ruleBody
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"pos",
							lv_pos_21_0,
							"org.di.unito.yarel.Yarel.Body");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_22=','
			{
				newLeafNode(otherlv_22, grammarAccess.getAtomicAccess().getCommaKeyword_6_4());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getZeroBodyParserRuleCall_6_5_0());
					}
					lv_zero_23_0=ruleBody
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"zero",
							lv_zero_23_0,
							"org.di.unito.yarel.Yarel.Body");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_24=','
			{
				newLeafNode(otherlv_24, grammarAccess.getAtomicAccess().getCommaKeyword_6_6());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getNegBodyParserRuleCall_6_7_0());
					}
					lv_neg_25_0=ruleBody
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"neg",
							lv_neg_25_0,
							"org.di.unito.yarel.Yarel.Body");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_26=']'
			{
				newLeafNode(otherlv_26, grammarAccess.getAtomicAccess().getRightSquareBracketKeyword_6_8());
			}
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyFunAction_7_0(),
						$current);
				}
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAtomicRule());
						}
					}
					otherlv_28=RULE_ID
					{
						newLeafNode(otherlv_28, grammarAccess.getAtomicAccess().getFunNameDeclarationCrossReference_7_1_0());
					}
				)
			)
		)
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getAtomicAccess().getBodyPermAction_8_0(),
						$current);
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAtomicAccess().getPermutationPermutationParserRuleCall_8_1_0());
					}
					lv_permutation_30_0=rulePermutation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAtomicRule());
						}
						set(
							$current,
							"permutation",
							lv_permutation_30_0,
							"org.di.unito.yarel.Yarel.Permutation");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRulePermutation
entryRulePermutation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPermutationRule()); }
	iv_rulePermutation=rulePermutation
	{ $current=$iv_rulePermutation.current; }
	EOF;

// Rule Permutation
rulePermutation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='/'
		{
			newLeafNode(otherlv_0, grammarAccess.getPermutationAccess().getSolidusKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getPermutationAccess().getIndexesDigitParserRuleCall_1_0());
				}
				lv_indexes_1_0=ruleDigit
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPermutationRule());
					}
					add(
						$current,
						"indexes",
						lv_indexes_1_0,
						"org.di.unito.yarel.Yarel.Digit");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getPermutationAccess().getIndexesDigitParserRuleCall_2_0());
				}
				lv_indexes_2_0=ruleDigit
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPermutationRule());
					}
					add(
						$current,
						"indexes",
						lv_indexes_2_0,
						"org.di.unito.yarel.Yarel.Digit");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='/'
		{
			newLeafNode(otherlv_3, grammarAccess.getPermutationAccess().getSolidusKeyword_3());
		}
	)
;

// Entry rule entryRuleDigit
entryRuleDigit returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDigitRule()); }
	iv_ruleDigit=ruleDigit
	{ $current=$iv_ruleDigit.current; }
	EOF;

// Rule Digit
ruleDigit returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_INT
			{
				newLeafNode(lv_value_0_0, grammarAccess.getDigitAccess().getValueINTTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getDigitRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.xtext.common.Terminals.INT");
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
