import java.math.BigInteger;

class Abonent
{
    private DiffieHellman diffieHellman = new DiffieHellman();
    private int randomizer;
    private String sms;
    public String name;
    private int primemod;

    private BigInteger secret;
    public int public_key;


    public Abonent(String name, int randomizer, int primemod, String sms)
    {
        this.name = name;
        this.primemod = primemod;
        this.sms = sms;
        this.randomizer = randomizer;
        public_key = diffieHellman.PrimeNumber;
        secret = diffieHellman.GetKey(this.randomizer, this.primemod, public_key);
        System.out.println("Публичный ключ " + name + ": " + public_key);
    }

    public Abonent(String name, int randomizer, int primemod) {

        this(name, randomizer, primemod, "");
    }

    public BigInteger GetKey(int prime)
    {
        BigInteger g = secret.pow(prime);
        BigInteger Chave = g.mod(new BigInteger(Integer.toString(primemod)));

        return Chave;
    }

    public String SendMessage(BigInteger key)
    {
        String encryptedMessage = diffieHellman.EncryptMessage(sms, key);

        return encryptedMessage;
    }

    public String GetMessage(String sms, BigInteger key)
    {
        String decryptedMessage = diffieHellman.DecryptMessage(sms, key);

        return decryptedMessage;
    }
}