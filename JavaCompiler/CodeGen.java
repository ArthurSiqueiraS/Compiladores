class CodeGen{

	
	float geraCodigo (ArvoreSintatica arv)
	{
		if (arv instanceof Operador) {
			float arg1 = (geraCodigo(((Operador) arv).arg1));
			float arg2 = (geraCodigo(((Operador) arv).arg2));	

			if (arv instanceof Soma) return arg1 + arg2;
			if (arv instanceof Sub) return arg1 - arg2;
			if (arv instanceof Mult) return arg1 * arg2;
			if (arv instanceof Div) return arg1 / arg2;
		}

		if (arv instanceof Num) {
			return ((Num) arv).getNum();
		}

		return 0;
	}
}
