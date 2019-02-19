public class Gays {

    public static Drob Ras(Drob P, Drob a, Drob b, Drob Gla){
        return (P.vichet((a.umnoz(b)).delen(Gla)));
    }
    public static Drob Sokr(Drob A){
        int mn=gcd(A.getChis(),A.getZnam());
     //   System.out.println(mn);
        A.setChis(A.getChis() / mn);
        A.setZnamen(A.getZnam() / mn);
        return A;
    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    /*public static int nod(int x,int y){
        int tmp= x%y ;
    x=y;
    y=tmp;
        if(tmp>0){
            return nod(x,y);
        }
        else {
            return x;
        }
    }
    static int nok(int x,int y){
        return x*(y / nod(x,y));
    }*/


    static int n = 4, m =6;
    static Drob[][] M = new Drob[n][m];
    static Drob[][] Pred = new Drob[n][m];

    public static void main(String[] args) {
        Drob a = new Drob();
        Drob b = new Drob();

        /*ArrayList<ArrayList<Drob>> Matrix = new ArrayList<>();
        Matrix.add(new );*/


        int[][] Matrix = {
           /*laba 9*/  /*   {8,2,-8,-10,-3,142},
                {6,-1,11,4,11,-55},
                {13,-9,4,3,10,-49},
                {-9,4,14,15,13,-213},
                {9,6,8,4,-7,152}*/

            /*3 dz*/    /*{1,4,0,-1,5},
                {2,-3,1,1,3},
                {1,0,2,-1,3},
                {0,2,-3,2,3}*/
         /*4 dz*/       {2,-1,1,2,3,2},
                {6,-3,2,4,5,3},
                {6,-3,4,8,13,9},
                {4,-2,1,1,2,1}

        };


        Drob GlavEl = new Drob();
        int GlavT = 0;
        int GlavE = 0;

        /*M[0][0]=new Drob();
        M[0][1]=new Drob();
        M[0][0].setChis(10);
        M[0][0].setZnamen(5);
        M[0][1].setChis(1);
        M[0][1].setZnamen(2);
        System.out.println(M[0][1].getChis());*/

        for(int e=0; e<n; e++) {
            for(int t=0; t<m; t++) {
                M[e][t]=new Drob();
                Pred[e][t]=new Drob();
                a.setChis(Matrix[e][t]);
                a.setZnamen(1);
                M[e][t].setChis(a.getChis());
                M[e][t].setZnamen(a.getZnam());
                Pred[e][t].setChis(a.getChis());
                Pred[e][t].setZnamen(a.getZnam());
                //Pred[e][t] = a;
                System.out.print(M[e][t].getChis() + "/" + M[e][t].getZnam() + " ");
            }
            System.out.println();
        }

        System.out.println();
boolean check = false;
        for(int e=0; e<n; e++){
            check=false;
            for(int t=0; t<m & !check; t++){
                if(M[e][t].getChis()==0){
                    if(t==m-1){

                        check=true;
                        break;
                    }
                    continue;
                }
                else if(M[e][t].getZnam()==0) {
                    continue;
                }
                    else {
                        GlavEl.setChis(M[e][t].getChis());
                        GlavEl.setZnamen(M[e][t].getZnam());
                        GlavT = t;
                        GlavE = e;
                        //System.out.println(GlavE + " " + GlavT);
                        System.out.println(GlavEl.getChis()+"/"+GlavEl.getZnam());
                        break;
                    }
                }
if(check) continue;
            /*for(int t=0; t<n; t++){
                for (int z=0; z<m; z++){
                    System.out.print(Pred[t][z].getChis()+"/"+Pred[t][z].getZnam()+" ");
                }
                System.out.println();
            }*/
            for(int z=0; z<n; z++){
                if(z!=GlavE) {
                    Pred[z][GlavT].setChis(0);
                    Pred[z][GlavT].setZnamen(0);
                    //System.out.println(z + " " + GlavT);
                }

            }

            for(int t=GlavT; t<m; t++){
                Pred[GlavE][t]=M[GlavE][t].delen(GlavEl);
            }
            //System.out.println(GlavE);
            //System.out.println(GlavT);
            for(int t=0; t<n; t++){
                if(t==GlavE)
                    continue;
                else {
                    for (int z = GlavT + 1; z < m; z++) {
                        Pred[t][z] = Ras(M[t][z], M[GlavE][z], M[t][GlavT], GlavEl);
                        //System.out.println(t+" " + GlavT + " " + M[t][GlavT].getChis()+"/"+M[t][GlavT].getZnam());
                        if (Pred[t][z].getChis() == 0)
                            Pred[t][z].setZnamen(0);
                    }
                }
            }

            for(int t=0; t<n; t++) {
                for (int z = 0; z < m; z++) {
                    if (Pred[t][z].getZnam()==0 | Pred[t][z].getChis() ==0);
                    else Pred[t][z] = Sokr(Pred[t][z]);
                    M[t][z].setChis(Pred[t][z].getChis());
                    M[t][z].setZnamen(Pred[t][z].getZnam());
                }
            }

                for(int t=0; t<n; t++){
                    for (int z=0; z<m; z++){
                        System.out.print(Pred[t][z].getChis()+"/"+Pred[t][z].getZnam()+" ");
                    }
                    System.out.println();
                }

            System.out.println();
        }

        /*for(int e=0; e<n; e++) {
            if(M[e][e].getChis()!=0) {
                GlavEl.setChis(M[e][e].getChis());
                GlavEl.setZnamen(M[e][e].getZnam());
            }
            else continue;

            for (int t = 0; t < m; t++) {
                Pred[e][t] = M[e][t].delen(GlavEl);
            }
            for(int x=0; x<m; x++){
                if(x!=e){
                    Pred[x][e].setChis(0);
                    Pred[x][e].setZnamen(0);
                }
            }
            for(int x=e+1; x<n; x++){
                for(int z=0; z<m; z++){
                    Drob r = Ras(M[x][z],M[x][e],M[e][z],GlavEl);
                    Pred[x][z].setChis(r.getChis());
                    Pred[x][z].setZnamen(r.getZnam());
                }
            }
            for(int y=0; y<m; y++){
                M[e][y].setChis(Pred[e][y].getChis());
                M[e][y].setZnamen(Pred[e][y].getZnam());
            }
            for (int t=0; t < n; t++) {
                for (int q = 0; q < m; q++) {
                    System.out.print(Pred[t][q].getChis() + "/" + Pred[t][q].getZnam() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }*/



        /*a.setChis(2);
        a.setZnamen(3);
        b.setChis(1);
        b.setZnamen(2);
        Drob result = a.vichet(b);
        System.out.println(result.getChis()+"/"+result.getZnam());*/
    }
}
