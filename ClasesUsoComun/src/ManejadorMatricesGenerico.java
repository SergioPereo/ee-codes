
public class ManejadorMatricesGenerico {
	
	public static <T extends Comparable <T>> boolean matricesIguales (T a[][], T b [][]) {
		int i, j,n,m,p,q;
		boolean bien;	
		n=a.length;
		m=a[0].length;
		p=b.length;
		q=b[0].length;
		i=0;
		bien=true;
		if (n!=p || m!=q)
			bien=false;
		else
			while(bien && i<n) {
				j=0;
				while(bien &&j<m) {
					if(a[i][j]!=b[i][j]) {
						bien=false;
					}
					j++;
				}
				i++;
			}
			        
		return bien;	
	}
	
	public static <T extends Comparable <T>> int indicaMayorFila (T a[][], int f) {
		int j, m, mayor;
		m = a[0].length;
		mayor = 0;
		for(j=1;j<m;j++) {
			if(a[f][j].compareTo(a[f][mayor])>0) {
				mayor = j;
			}
		}
		return mayor;
	}
	
	public static <T extends Comparable <T>> int indicaMayorColumna(T a[][], int b) {
		 int j, n, mayor;
		 n = a.length;
		 mayor=0;
		 for(j=1;j<n;j++)
			 if(a[j][b].compareTo(a[mayor][b])>0)
				 mayor=j;
		 return mayor;
	}
	
	public static <T extends Comparable <T>> int indicaMenorColumna(T a[][], int b) {
		 int j, n, mayor;
		 n = a.length;
		 mayor=0;
		 for(j=1;j<n;j++)
			 if(a[j][b].compareTo(a[mayor][b])<0)
				 mayor=j;
		 return mayor;
	}
	
	public static <T extends Comparable <T>> int indicaMenorFila (T a[][], int f) {
		int j, m, menor;
		m = a[0].length;
		menor = 0;
		for(j=1;j<m;j++) {
			if(a[f][j].compareTo(a[f][menor])<0) {
				menor = j;
			}
		}
		return menor;
	}
	
	public static <T extends Comparable <T>> int buscaPorRenglon (T a[][], int f, T valor) {
		int n, m, j;
		boolean encontre;
		
		n = a.length;
		m= a[0].length;
		j=0;
		encontre = false;
		while(j<m && !encontre) {
			if(a[f][j] != null && a[f][j].equals(valor))
				encontre = true;
			else
				j++;
		}
		if(!encontre) {
			j=-1;
		}
		return j;
	}
	
	public static <T extends Comparable <T>> int[] buscaEnElArreglo (T a[][], T valor) {
		int n, m, i, j;
		boolean encontre;
		int[] r = {-1, -1};
		n = a.length;
		m= a[0].length;
		i=0;
		j=0;
		encontre = false;
		while(i<n && !encontre) {
			while(j<m && !encontre) {
				if(a[i][j].compareTo(valor) == 0) {
					encontre = true;
				} else {
					j++;
				}
			}
			i++;
		}
		if(encontre) {
			r[0] = i;
			r[1] = j;
		} 
		return r;
	}
	
	public static <T extends Comparable<T>> void incognita(T a[][]) {
		int i, j, n, m;
		n=a.length;
		m=a[0].length;
		for(i=0;i<n;i++) {
			for(j=0;j<=i;j++) {
				if(i==j) {
					a[i][j]=null;
				} else {
					if(a[i][j].compareTo(a[j][i])<0) {
						a[i][j]=a[j][i];
					}
					a[i][j]=null;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> String convierteStringMatriz(T a[][], int n, int m) {
		int i, j;
		StringBuilder sb;
		sb = new StringBuilder();
		for(i=0 ; i<n ; i++) {
			for(j=0 ; j<m ; j++) {
				sb.append(a[i][j].toString() + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static <T extends Comparable<T>> boolean menoresDiagonales(T a[][], T b[][]) {
		int length = a.length;
		for(int i=0 ; i<a.length ; i++) {
			if(a[i][length-i-1].compareTo(b[i][length-i-1]) > 0) {
				return false;
			}
		}
		for(int i=length-2 ; i>-1 ; i--) {
			if(a[i][(length-2)-i].compareTo(b[i][(length-2)-i]) > 0) {
				return false;
			}
		}
		for(int i=length-1 ; i>0 ; i--) {
			if(a[i][length-i].compareTo(b[i][length-i]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	
}
