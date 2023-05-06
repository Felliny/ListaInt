package Biblioteca.ListaInt;


import java.io.IOException;

public class ListaInt {

    No primeiro;


    public ListaInt(){
        primeiro= null;
    }

    public boolean isEmpty() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int cont = 0;
        if (!isEmpty()) {
            No auxiliar = primeiro;
            while (auxiliar != null) {
                cont++;
                auxiliar = auxiliar.proximo;
            }
        }
        return cont;
    }

    private No getNo(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posição Inválida");
        }
        No auxiliar = primeiro;
        int cont = 0;
        while (cont < pos) {
            auxiliar = auxiliar.proximo;
            cont++;
        }
        return auxiliar;
    }

    public void addFirst(int valor) {
        SetInt(valor);
        No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = primeiro;
        primeiro = elemento;
    }

    public void addLast(int valor) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        SetInt(valor);
        No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = null;

        int tamanho = size();

        No ultimo = getNo(tamanho - 1);
        ultimo.proximo = elemento;
    }

    public void add(int valor, int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        SetInt(valor);
        int tamanho = size();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Posição inválida");
        }
        if (pos == 0) {
            addFirst(valor);
        } else if (pos == tamanho) {
            addLast(valor);
        } else {
            No elemento = new No();
            elemento.dado = valor;

            No anterior = getNo(pos - 1);
            elemento.proximo = anterior.proximo;
            anterior.proximo = elemento;
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        primeiro = primeiro.proximo;
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (tamanho == 1) {
            removeFirst();
        } else {
            No penultimo = getNo(tamanho - 2);
            penultimo.proximo = null;
        }
    }

    public void remove(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posição Inválida");
        }
        if (pos == 0) {
            removeFirst();
        } else if (pos == tamanho - 1) {
            removeLast();
        } else {
            No atual = getNo(pos);
            No anterior = getNo(pos - 1);
            anterior.proximo = atual.proximo;
        }
    }

    public int get(int pos) throws Exception {
        No atual = getNo(pos);
        return atual.dado;
//		return getNo(pos).dado;
    }

    public void SetInt(int valor){
        int tamanho= size();
        int cont= 0;
        while (cont < tamanho){
            try {
                if (get(cont) == valor){
                    throw new IOException("Dado já inserido na lista!");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            cont++;
        }
    }

}
