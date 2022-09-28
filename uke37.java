import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class uke37 {
    public static void main(String[] args) {
for(int i=1;i<10;i++){
    System.out.println(ternaryIf(i));

}
        Integer[] a={1,4,55,66,22,11,8,3};
        Character[] b={'A','Z','B', 'C'};
        String [] c={"Aos", "Aram","Kenan", "Abou", "shakra"};
        System.out.println(maks(a));
        System.out.println(maks(b));
        System.out.println(maks(c));
        Person[] d={new Person("Kenan","Abou Shakra"), new Person("Aos","Abou Shakra"), new Person("Shatha", "Amer"), new Person("Aram", "Abou Shakra")};
        System.out.println(maks(d));
        String r = "a", t = "z";
        System.out.println(r.compareTo(t));
        System.out.println(Boolean.compare(true, false));
        String[] g = {"Per","Kari","Ole","Anne","Ali","Eva"};
        innsettingssortering(g);
        System.out.println(Arrays.toString(g));  // [Ali, Anne, Eva, Kari, Ole, Per]
        skrivUt(g, 2,4);
        skrivUt(a, 2,4);
        skrivUt(randPermInteger(20), 0, 19);
        for (Studium q: Studium.values()){
            System.out.println(q.toString()+" ("+ q.name()+")");
            Student[] s = new Student[5];  // en Studenttabell

            s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
            s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
            s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
            s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
            s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

           innsettingssortering(s);                     // Programkode 1.4.2 e)
            for (Student y : s) System.out.println(y);
            innsettingssortering(g, Komparator.omvendtOrden());
            System.out. println(Arrays.toString(g));
        }
    }


    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi, a[j]) < 0; j--) a[j + 1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }
    public static void bytt(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public enum  Studium{
        Data ("Ingeniørfag - data"),         // enumkonstanten Data
        IT ("Informasjonsteknologi"),        // enumkonstanten IT
        Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
        Enkeltemne ("Enkeltemnestudent"); // enumkonstanten Enkeltemne
        private final String fulltnavn;
        private Studium (String fulltnavn){
            this.fulltnavn=fulltnavn;
        }
        public String toString(){
            return fulltnavn;
        }
    }
    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i +10);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
   public static <T extends Comparable<? super T>> void innsettingssortering(T[] a){
        for (int i=1; i<a.length; i++){
           T verdi=a[i];
           int j=i-1;
           for(; j>=0 &&verdi.compareTo(a[j])<0; j--)  {a[j+1]=a[j];a[j]=verdi;}
           }

   }
   public static <T extends Comparable<? super T>> void skrivUt(T[] a, int fra, int til){
        String u="";
for(int i=fra; i<til; i++){
    u+=a[i]+", ";
}
u+=a[til];
System.out.println(u);
   }
    public static int ternaryIf(int a){
        return (a<5)?0:90;
    }
    static <T extends Comparable<? super T>> int maks(T[] a){
        T mv=a[0];
        int m=0;
        for (int i=1;i<a.length;i++){
            if(a[i].compareTo(mv)>0){
                mv=a[i];
                m=i;
            }
        }return m;
    }
    public static class Person implements Comparable<Person>{
        String fnavn;
        String enavn;
        Person(String fnavn, String enavn){
            this.fnavn=fnavn;
            this.enavn=enavn;
        }
        public int compareTo(Person other){
            int lComper=this.enavn.compareTo(other.enavn);
            if(lComper==0){
                return this.fnavn.compareTo(other.fnavn);
            }else {
                return lComper;
            }
        }
    }
}
class Student extends Person{
    private  uke37.Studium studium;
    public Student(String fornavn, String etternavn, uke37.Studium studium){
        super(fornavn,etternavn);
        this.studium=studium;
    }
    public String toString(){ return super.toString()+" "+studium.name();}

}
class Person implements Comparable<Person> {
    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn)   // konstruktør
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() {
        return fornavn;
    }       // aksessor

    public String etternavn() {
        return etternavn;
    }   // aksessor

    public int compareTo(Person p)    // pga. Comparable<Person>
    {
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Object o)      // vår versjon av equals
    {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person) o) == 0;
    }

    public int hashCode() {
        return Objects.hash(etternavn, fornavn);
    }

    public String toString() {
        return fornavn + " " + etternavn;
    }

}