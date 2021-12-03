import java.io.*;

class TextReader
{
    static public String ReadText(String path)
    {
        String original = "";
        String path_name = path;
        String line;
        original = new String();

        try {

            File file = new File(path_name);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            line = reader.readLine();

            while (line != null) {

                line += '\n';
                original += line;
                line = reader.readLine();
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

        return original;
    }

    static public void WriteText(String path, String text)
    {
        try(FileWriter writer = new FileWriter(path, false))
        {

            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}