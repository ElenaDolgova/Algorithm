package CSC.CodeForces_input_test.Codeforce.Contest_1;

import Lafore.Chap4.StackX;
import Stepic.TheoryAndPractise_DataStructure.Stack;

import java.util.Scanner;

/**
 * C. Постфиксная запись
 * ограничение по времени на тест1 секунда
 * ограничение по памяти на тест256 мегабайт
 * вводстандартный ввод
 * выводстандартный вывод
 * В постфиксной записи (или обратной польской записи) операция записывается после двух операндов.
 * Например, сумма двух чисел A и B записывается как A B +. Запись B C + D * обозначает привычное нам (B + C) * D,
 * а запись A B C + D * + означает A + (B + C) * D. Достоинство постфиксной записи в том, что она не требует скобок
 * и дополнительных соглашений о приоритете операторов для своего чтения.
 * <p>
 * Дано выражение в обратной польской записи. Определите его значение.
 * <p>
 * Входные данные
 * В единственной строке записано выражение в постфиксной записи, содержащее однозначные числа и операции  + ,  - ,  * .
 * Строка содержит не более 100 чисел и операций.
 * <p>
 * Выходные данные
 * Необходимо вывести значение записанного выражения. Гарантируется, что результат выражения,
 * а также результаты всех промежуточных вычислений по модулю меньше 2^31.
 */

public class InfixToPostfix{
	public static StringBuilder out;
	//private Stack<Character> stackX;
	private StackX<Character> stackX;
	private String str;
	
	public InfixToPostfix( ){
		Scanner s = new Scanner(System.in);
		str = s.next( );
		out = new StringBuilder(str.length( ));
		stackX = new StackX<>( );
	}
	
	public InfixToPostfix(String str){
		this.str = str.replaceAll(" ", "");
		out = new StringBuilder(str.length( ));
		stackX = new StackX<>( );
	}
	
	public InfixToPostfix setStr(String str){
		this.str = str;
		return this;
	}
	
	public InfixToPostfix run( ){
		char ch, ch0;
		for (int i = 0; i < str.length( ); i++){
			ch = str.charAt(i);
			if (isNumber(ch)){
				out.append(ch);
				if (i == str.length( ) - 1){
					while (!stackX.isEmpty( )){
						if (stackX.peek( ) != '('){
							out.append(stackX.pop( ));
						}else
							stackX.pop( );
					}
					continue;
				}
				continue;
			}
			if (ch == ')' && (i == str.length( ) - 1)){
				while (!stackX.isEmpty( )){
					if (stackX.peek( ) != '('){
						out.append(stackX.pop( ));
					}else
						stackX.pop( );
				}
				continue;
			}
			
			switch (ch){
				case '(':
					stackX.push(ch);
					break;
				case ')':
					ch0 = stackX.pop( );
					while (ch0 != '('){
						out.append(ch0);
						ch0 = stackX.pop( );
					}
					break;
				default:
					if (stackX.isEmpty( )){
						stackX.push(ch);
					}else{
						while (!stackX.isEmpty( )){
							ch0 = stackX.pop( );
							if (ch0 == '('){
								stackX.push(ch0);
								break;
							}else if (!priorityOperator(ch, ch0)){
								out.append(ch0);
							}else{
								stackX.push(ch0);
								break;
							}
						}
						stackX.push(ch);
					}
			}
			
		}
		return this;
	}
	
	/**
	 * @param ch0 из строки
	 * @param ch1 из стека
	 * @return Если ch0 имеет приоритет ниже чем ch1, то false, в ином случае, если больше либо равен, то true
	 */
	private boolean priorityOperator(char ch0, char ch1){
		switch (ch0){
			case '-':
			case '+':
				if (ch1 == '*' || ch1 == '/'){
					return false;
				}else{
					return true;
				}
			default:
				return true;
		}
	}
	
	private boolean isNumber(char var){
		return var >= '0' && var <= '9';
		
	}
	
}
