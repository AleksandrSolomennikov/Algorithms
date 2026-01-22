// ru version below

# EN

## Algorithms 1 – University Project

### Overview

This project implements classic algorithms and data structures in Java, organized into four main modules:

- Sorting Algorithms
- Knapsack Problem
- Hash Table (p-sum problem)
- Shortest Path in Graphs

Each module contains multiple solution variants to compare performance and efficiency.

---

## Table of Contents

- [Sorting Algorithms](#sorting-algorithms)
- [Knapsack Problem](#knapsack-problem)
- [Hash Table (p-sum problem)](#hash-table-p-sum-problem)
- [Shortest Path in Graphs](#shortest-path-in-graphs)
- [Project Structure](#project-structure)
- [Testing](#testing)

---

## Sorting Algorithms

**File:** `Algos.java`

Implements several sorting algorithms:
- Merge Sort
- Bubble Sort
- Quick Sort

**Usage:**  
Run or import `Algos.java` to test and benchmark the sorting algorithms on sample data.

---

## Knapsack Problem

**File:** `KnapsackProblem/Backtracking.java`

Solves the classic knapsack problem using:
- Backtracking
- Dynamic Programming

**Usage:**  
Use the provided test files in `KnapsackProblem/Knapsack tests/` to evaluate algorithm performance.

---

## Hash Table (p-sum problem)

**File:** `HashtableTP.java`

Implements a solution for the p-sum problem using Java's built-in `hashCode()` function.

**Usage:**  
Test files are available in `Hashtable tests/` for validation and benchmarking.

---

## Shortest Path in Graphs

**File:** `Graphs/Graph.java`  
**Entry Point:** `Algos.java`

Implements Dijkstra's algorithm for finding the shortest path, utilizing `PriorityQueue` and Java streams for efficiency.

**Usage:**  
Graph data can be loaded from files in `Graphs/Graph tests/`.

---

## Project Structure

```
.
├── Algos.java
├── HashtableTP.java
├── README.md
├── Graphs/
│   ├── Arc.java
│   ├── Graph.java
│   ├── Vertex.java
│   └── Graph tests/
├── Hashtable tests/
├── KnapsackProblem/
│   ├── Backtracking.java
│   ├── Item.java
│   └── Knapsack tests/
└── .vscode/
```

---

## Testing

Test data is provided in the respective `tests` directories for each module.  
Modify or extend these files to benchmark and validate algorithm implementations.

---

## Author

- [Aleksandr Solomennikov]
- [Aix-Marseille Université / Faculté des Sciences]

---


# RU

## Университетский проект "Алгоритмы 1"

### Описание

Данный проект реализует классические алгоритмы и структуры данных на Java, сгруппированные в четыре основных модуля:

- Алгоритмы сортировки
- Задача рюкзака
- Хэш-таблица (задача p-суммы)
- Кратчайший путь в графе

В каждом модуле реализовано несколько вариантов решений для сравнения производительности и эффективности.

---

## Содержание

- [Алгоритмы сортировки](#алгоритмы-сортировки)
- [Задача рюкзака](#задача-рюкзака)
- [Хэш-таблица (задача p-суммы)](#хэш-таблица-задача-p-суммы)
- [Кратчайший путь в графе](#кратчайший-путь-в-графе)
- [Структура проекта](#структура-проекта)
- [Тестирование](#тестирование)

---

## Алгоритмы сортировки

**Файл:** `Algos.java`

Реализованы следующие алгоритмы сортировки:
- Сортировка слиянием
- Сортировка пузырьком
- Быстрая сортировка (Quick Sort)

**Использование:**  
`javac Algos.java` - компиляция

`java Algos` - запуск

В функции `main` можно выбрать необходимый алгоритм.

---

## Задача рюкзака

**Файл:** `KnapsackProblem/Backtracking.java`

Реализовано решение задачи рюкзака с помощью:
- Бэктрекинга
- Динамического программирования

**Использование:**
`javac KnapsackProblem/Backtracking.java` - компиляция

`java KnapsackProblem/Backtracking` - запуск

В функции `main` можно задать параметры задачи.

---

## Хэш-таблица (задача p-суммы)

**Файл:** `HashtableTP.java`

Реализовано решение задачи p-суммы с использованием стандартной функции `hashCode()` в Java.

**Использование:**  
`javac HashtableTP.java` - компиляция 

`java HashtableTP` - запуск

В функции `main` можно задать параметры задачи.

---

## Кратчайший путь в графе

**Файл:** `Graphs/Graph.java`  
**Точка входа:** `Algos.java`

Реализован алгоритм Дейкстры для поиска кратчайшего пути с использованием `PriorityQueue`.

**Использование:**  
В функции `main` в файле `Algos.java` указывается использование этого алгоритма.

---

## Структура проекта

```
.
├── Algos.java
├── HashtableTP.java
├── README.md
├── Graphs/
│   ├── Arc.java
│   ├── Graph.java
│   ├── Vertex.java
│   └── Graph tests/
├── Hashtable tests/
├── KnapsackProblem/
│   ├── Backtracking.java
│   ├── Item.java
│   └── Knapsack tests/
└── .vscode/
```

---

## Тестирование

Тестовые данные находятся в соответствующих папках `tests` для каждого модуля. Тесты используются в функции `main`, необходимо лишь запустить нужный файл.

---

## Автор

- [Александр Соломенников]
- [Университет Экс-Марселя / Научный Факультет]

---