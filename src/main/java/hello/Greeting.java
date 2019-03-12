package hello;

public class Greeting {

    private final long id;
    private final String content;
    private int idade;

    public Greeting(long id, String content, int idade) {
        this.id = id;
        this.content = content;
        this.idade = idade;
    }


    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getIdade() {
        return idade;
    }
}


