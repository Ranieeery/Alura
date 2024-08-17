public class TesteEnum {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> System.out.println("Rodando..."));
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        Prioridade pMin = Prioridade.MIN;
        Prioridade pNor = Prioridade.NORMAL;
        Prioridade pMax = Prioridade.MAX;

        System.out.println(pMin.ordinal() + " - " + pMin.name());
        System.out.println(pNor.ordinal() + " - " + pNor.name());
        System.out.println(pMax.ordinal() + " - " + pMax.name());

        System.out.println("-------------");

        System.out.println(pMin.getValor() + " - " + pMin.name());
        System.out.println(pNor.getValor() + " - " + pNor.name());
        System.out.println(pMax.getValor() + " - " + pMax.name());
    }
}
