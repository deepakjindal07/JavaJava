package temp;

class fibonnaci {

    public static void main(String[] args) {

        int n = 10;

        int Firstnum = 0;
        int Secondnum = 1;

        System.out.println("Print till " + n);

        for (int i = 1; i < n; ++i) {

            System.out.println(Firstnum + " ");

            int Nextnum = Firstnum + Secondnum;  // temp = 0+1
            Firstnum = Nextnum;
            //Secondnum = Nextnum + Secondnum;

        }
    }
}