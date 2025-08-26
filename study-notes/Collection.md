# 컬렉션 자료구조
* java.util 패키지
컬렉션 프레임워크 : 인터페이스를 통해서 다양한 컬렉션 클래스를 이용할 수 있도록 설계됨

* Collection 프레임워크 구조
```java
Collection (인터페이스) 
├── List (순서 O, 중복 O)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
           └── Stack(LIFO, 후입선출)
├── Set (순서 X, 중복 X)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (FIFO, 선입선출)
    ├── PriorityQueue
    └── ArrayDeque
    
Map (인터페이스, key-value) 
├── HashMap
├── LinkedHashMap
└── TreeMap
//-> Map은 Collection을 상속하지 않고 별도의 구조지만 컬렉션 프레임워크에 포함된다.
``` 

* Collection (인터페이스) : 모든 컬렉션의 최상위 인터페이스
    공통 메서드 사용가능 : add(), remove(), size()
    컬렉션 프레임워크에서 Collection 인터페이스를 구현(implements)하게 만든 이유는
    모든 컬렉션 클래스가 공통으로 제공하는 메서드들을 강제하기 위해서.
    Collection 인터페이스에는 add(), remove(), size(), isEmpty()같은 공통 메서드가
    정의되어있다. 
    모든, List, Set, Queue 구현체는 이 메서드를 반드시 구현해야함
    -> 공통으로 일관되게 사용이 가능하다.
    구현체가 달라도 같은 이름으로 호출이 가능함
    -> 공통 메서드 사용을 위해 인터페이스로 강제로 구현하게 만든것(재사용성, 유지보수, 다형성)

* List : 순서를 유지하고 저장, 중복 있음
* Set : 순서 없음, 중복 안됨
* Queue : FIFO 구조
* Map : key-value(키는 중복 X)

+ java 21버전에서는 순차 컬레견 기능이 추가되었음


## List
* 순서와 중복을 허용하는 컬렉션 인터페이스
    * 순서 보장 : 데이터 입력 순서 유지
    * 중복 허용 : 같은 값을 여러번 저장이 가능하다
    * 인덱스 접근 가능 : 배열처럼 get(index)사용 가능
    객체 자체를 저장하는 것이 아니라 객체의 번지를 저장한다.
    동일한 객체를 중복 저장 가능하고, null도 저장 가능

* List 주요 구현 클래스

    * ArrayList
        배열을 이용한 리스트, 값들이 연속된 메모리 공간에 저장됨
        값 저장(add), 삭제(remove)가 느리다
        이유 : 배열이라 인덱스로 바로 접근 가능하지만(검색 빠름)
        중간에 삽입/삭제 시 뒤에 있는 요소들을 이동해야함 -> 느리다.
        ```
        삽입: [A,B,C,D] -> insert X at index 1 -> [A,X,B,C,D] (B,C,D 이동)
        삭제: [A,B,C,D] -> remove B -> [A,C,D] (C,D 이동)
        ```
    * LinkedList
        노드가 서로 포인터로 연결
    * Vector
    * Stack