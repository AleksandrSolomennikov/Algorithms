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

## Authors

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
Запустите или импортируйте `Algos.java` для тестирования и сравнения алгоритмов сортировки на примерах данных.

---

## Задача рюкзака

**Файл:** `KnapsackProblem/Backtracking.java`

Реализовано решение задачи рюкзака с помощью:
- Бэктрекинга
- Динамического программирования

**Использование:**  
Используйте тестовые файлы из `KnapsackProblem/Knapsack tests/` для оценки производительности алгоритмов.

---

## Хэш-таблица (задача p-суммы)

**Файл:** `HashtableTP.java`

Реализовано решение задачи p-суммы с использованием стандартной функции `hashCode()` в Java.

**Использование:**  
Тестовые файлы находятся в папке `Hashtable tests/` для проверки и сравнения решений.

---

## Кратчайший путь в графе

**Файл:** `Graphs/Graph.java`  
**Точка входа:** `Algos.java`

Реализован алгоритм Дейкстры для поиска кратчайшего пути с использованием `PriorityQueue` и потоков Java.

**Использование:**  
Данные графа можно загрузить из файлов в папке `Graphs/Graph tests/`.

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

Тестовые данные находятся в соответствующих папках `tests` для каждого модуля.  
Вы можете изменять или дополнять эти файлы для сравнения и проверки решений.

---

## Авторы

- [Александр Соломенников]
- [Университет Экс-Марселя / Научный Факультет]

---