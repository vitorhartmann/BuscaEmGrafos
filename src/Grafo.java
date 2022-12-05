import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo {

    private List<String> Vertices;
    private int[][] MatrizSecundaria;

    public Grafo(int NumeroVertices) {
        Vertices = new ArrayList<>(NumeroVertices);
        MatrizSecundaria = new int[NumeroVertices][NumeroVertices];
    }

    public void AdiciorVertice(String vertice) {
        Vertices.add(vertice);
    }

    public void adicionarAresta(int indiceVertice1, int indiceVertice2) {
        MatrizSecundaria[indiceVertice1][indiceVertice2] = 1;
        MatrizSecundaria[indiceVertice2][indiceVertice1] = 1;
    }

    public void MostrarMatrizSecundaria() {

        System.out.print("  ");
        for (String Vertice : Vertices) {
            System.out.print(Vertice + " ");
        }
        System.out.println();

        for (int i = 0; i < Vertices.size(); i++) {
            System.out.print(Vertices.get(i) + " ");
            for (int j = 0; j < Vertices.size(); j++) {
                System.out.print(MatrizSecundaria[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int menosVizinhos() {

        int minVizinhos = Integer.MAX_VALUE;
        int minEstado = -1;
        for (int i = 0; i < this.MatrizSecundaria.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j < this.MatrizSecundaria[i].length; j++) {
                if (this.MatrizSecundaria[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos < minVizinhos) {
                minVizinhos = vizinhos;
                minEstado = i;
            }
        }

        return minEstado;

    }

    public int maisVizinhos() {

        int maxVizinhos = Integer.MIN_VALUE;
        int maxEstado = -1;
        for (int i = 0; i < this.MatrizSecundaria.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j < this.MatrizSecundaria[i].length; j++) {
                if (this.MatrizSecundaria[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos > maxVizinhos) {
                maxVizinhos = vizinhos;
                maxEstado = i;
            }
        }

        return maxEstado;
    }

    public void menorCaminho(int InicioGrafo, int FimGrafo) {

        Queue<Integer> queue = new LinkedList<>();

        int[] path = new int[this.MatrizSecundaria.length];

        boolean[] Visitado = new boolean[this.MatrizSecundaria.length];
        Visitado[InicioGrafo] = true;

        queue.add(InicioGrafo);
        while (!queue.isEmpty()) {
            int Percorrer = queue.remove();

            for (int i = 0; i < this.MatrizSecundaria[Percorrer].length; i++) {
                if (this.MatrizSecundaria[Percorrer][i] == 1 && !Visitado[i]) {
                    Visitado[i] = true;
                    queue.add(i);
                    path[i] = Percorrer;

                    if (i == FimGrafo) {
                        break;
                    }
                }
            }
        }
        System.out.print("Menor caminho entre dois estados: ");
        int Percorrer = FimGrafo;
        while (Percorrer != InicioGrafo) {
            System.out.print(Percorrer + " > ");
            Percorrer = path[Percorrer];
        }
        System.out.println(InicioGrafo);
    }

    public void encontrarTodosOsCaminhos(int InicioGrafo, int FimGrafo) {
        Stack<Integer> stack = new Stack<>();
        int[] path = new int[this.MatrizSecundaria.length];
        boolean[] Visitado = new boolean[this.MatrizSecundaria.length];
        Visitado[InicioGrafo] = true;

        stack.push(InicioGrafo);
        while (!stack.isEmpty()) {
            int Percorrer = stack.pop();

            for (int i = 0; i < this.MatrizSecundaria[Percorrer].length; i++) {
                if (this.MatrizSecundaria[Percorrer][i] == 1 && !Visitado[i]) {
                    Visitado[i] = true;
                    stack.push(i);
                    path[i] = Percorrer;

                    if (i == FimGrafo) {
                        System.out.print("Caminho possível: ");
                        Percorrer = FimGrafo;
                        while (Percorrer != InicioGrafo) {
                            System.out.print(Percorrer + " > ");
                            Percorrer = path[Percorrer];
                        }
                        System.out.println(InicioGrafo);
                        stack.pop();
                        Visitado[i] = false;
                    }
                }
            }
        }

    }

    public void Estados() {

        // Adicionar nome dos estados aos vertices
        this.AdiciorVertice("Acre");
        this.AdiciorVertice("Alagoas");
        this.AdiciorVertice("Amapá");
        this.AdiciorVertice("Amazonas");
        this.AdiciorVertice("Bahia");
        this.AdiciorVertice("Ceará");
        this.AdiciorVertice("Distrito Federal");
        this.AdiciorVertice("Espírito Santo");
        this.AdiciorVertice("Goiás");
        this.AdiciorVertice("Maranhão");
        this.AdiciorVertice("Mato Grosso");
        this.AdiciorVertice("Mato Grosso do Sul");
        this.AdiciorVertice("Minas Gerais");
        this.AdiciorVertice("Pará");
        this.AdiciorVertice("Paraíba");
        this.AdiciorVertice("Paraná");
        this.AdiciorVertice("Pernambuco");
        this.AdiciorVertice("Piauí");
        this.AdiciorVertice("Rio de Janeiro");
        this.AdiciorVertice("Rio Grande do Norte");
        this.AdiciorVertice("Rio Grande do Sul");
        this.AdiciorVertice("Rondônia");
        this.AdiciorVertice("Roraima");
        this.AdiciorVertice("Santa Catarina");
        this.AdiciorVertice("São Paulo");
        this.AdiciorVertice("Sergipe");
        this.AdiciorVertice("Tocantins");

        // Inicio adicionar estados as vertices
        this.adicionarAresta(0, 3);
        this.adicionarAresta(3, 22);
        this.adicionarAresta(3, 13);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(21, 10);
        this.adicionarAresta(13, 2);
        this.adicionarAresta(13, 10);
        this.adicionarAresta(13, 9);
        this.adicionarAresta(13, 26);
        this.adicionarAresta(10, 26);
        this.adicionarAresta(10, 8);
        this.adicionarAresta(10, 11);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(9, 26);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(17, 5);
        this.adicionarAresta(5, 19);
        this.adicionarAresta(5, 14);
        this.adicionarAresta(5, 16);
        this.adicionarAresta(19, 14);
        this.adicionarAresta(14, 16);
        this.adicionarAresta(16, 1);
        this.adicionarAresta(16, 4);
        this.adicionarAresta(16, 17);
        this.adicionarAresta(1, 25);
        this.adicionarAresta(25, 4);
        this.adicionarAresta(4, 12);
        this.adicionarAresta(4, 17);
        this.adicionarAresta(4, 26);
        this.adicionarAresta(4, 7);
        this.adicionarAresta(4, 8);
        this.adicionarAresta(8, 26);
        this.adicionarAresta(8, 12);
        this.adicionarAresta(8, 6);
        this.adicionarAresta(6, 12);
        this.adicionarAresta(12, 7);
        this.adicionarAresta(12, 18);
        this.adicionarAresta(12, 24);
        this.adicionarAresta(12, 10);
        this.adicionarAresta(18, 7);
        this.adicionarAresta(18, 24);
        this.adicionarAresta(10, 24);
        this.adicionarAresta(24, 15);
        this.adicionarAresta(15, 23);
        this.adicionarAresta(15, 11);
        this.adicionarAresta(15, 20);
        // Fim adicionar estados as vertices
    }

    public static void main(String args[]) {

        // 27 estados, 27 vertices
        Grafo grafo = new Grafo(27);
        grafo.Estados();

        int min = grafo.menosVizinhos(), max = grafo.maisVizinhos();
        System.out.println("Menor numero de vizinhos: " + grafo.Vertices.get(min));
        System.out.println("Maior numero de vizinhos: " + grafo.Vertices.get(max));

        grafo.menorCaminho(2, 17);
        grafo.encontrarTodosOsCaminhos(2, 17);

    }

}
