package com.company;

public class Main {
public static void main(String[] args) {
    int size = 999; /* размер массива */
    int array[] = new int[size];
    random_array (array);
    print_array (array);
    Long start = System.currentTimeMillis();
    selection_sort (array);
    Long end = System.currentTimeMillis();
    Long pass_time = end - start;
    print_array (array);
    System.out.println("Время сортировки выбором " + pass_time);

    random_array (array);
    print_array (array);
    start = System.currentTimeMillis();
    insert_sort (array);
    end = System.currentTimeMillis();
    pass_time = end - start;
    print_array (array);
    System.out.println("Время сортировки вставками " + pass_time);

}
static void print_array (int array[]) { /* функция выводит в консоль содержимое массива */
    for (int i = 0; i < array.length; i++) {
        System.out.print ("[" + i + "] " + array[i]+ " ");
    }
    System.out.println("");
}
static void random_array (int array[]) { /* функция заполняет массив случайными числами */
    int random_max = 666; /* максимум */
    for (int i = 0; i < array.length; i++)
    {
        array [i] = (int) (Math.random() * random_max);
    }
}
static void swap_elem (int array[], int first, int second) { /* функция меняет два элемента в массиве местами */
    int temp = array [first];
    array [first] = array [second];
    array [second] = temp;
}

static void selection_sort (int array[]) { /* сортирует массив методом выбора */
    for (int i = 0; i < array.length; i++)
    {
        int min = array [i]; /* устанавливаем минимальный элемент */
        int n_min = i;
        for (int j = i+1; j < array.length; j++) /* в правой (от i) части массива ищем минимальный */
        {
            if (array[j] < min)
            {
                min = array [j];
                n_min = j;
            }
        }
        if (n_min != i) swap_elem (array, i, n_min); /* меняем местами i-й и минимальный элемент массива */
    }
}

static void insert_sort (int array[]){ /* сортирует массив методом вставки */
    for (int i = 1; i < array.length; i++) {
        int temp = array [i];
        int j = i;
        while (j > 0 && array [j-1] > temp)
        {
            array [j] = array [j-1]; /* сдвигаем часть массива */
            j--;
        }
        array [j] = temp;
    }
}
}
