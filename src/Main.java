import java.math.BigInteger;

class Main
{

    public static void main(String[] args)
    {
        Primes primeNum = new Primes();

        String message = TextReader.ReadText("messages/Input.txt");

        int randomizeer = primeNum.GetPrimeNumber();
        int primemod = primeNum.GetPrimeNumber();

        Abonent alice = new Abonent("Alice", randomizeer, primemod, message);
        Abonent bob = new Abonent("Bob", randomizeer, primemod);

        BigInteger keyAlice = alice.GetKey(bob.prime);
        BigInteger keyBob = bob.GetKey(alice.prime);

        System.out.println("Ключ Алисы: " + keyAlice + " Ключ Боба: " + keyBob);

        String encrypteMessage = alice.SendMessage(keyAlice);

        TextReader.WriteText("messages/Encrypted.txt", encrypteMessage);

        String decryptedMessage = bob.GetMessage(encrypteMessage, keyBob);

        TextReader.WriteText("messages/Decrypted.txt", decryptedMessage);
    }
}