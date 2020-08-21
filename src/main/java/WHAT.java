import java.util.Random;

public class WHAT
{
    public static void main(String[] args) throws Exception
    {
        char[] c = {'A','B','C','D'};
        Random random = new Random();
        for (int i=0; i<c.length; i++)
        {
            System.out.println(c[random.nextInt(4)]);
        }
    }
}