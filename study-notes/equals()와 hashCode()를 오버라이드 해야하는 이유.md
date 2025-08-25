* 자바의 모든 클래스들은 java.lang패키지의 Object클래스를 자동으로 상속받는다.

## equals()
* Object의 equals()메서드는 객체의 번지(메모리주소)를 비교하고
    boolean값으로 리턴한다.
    ```java
    public boolean equals(Object obj)
    // 파라미터가 Object이므로 모든 객체가 자동 타입 변환 되므로 대입이 가능하다.
    // 동일한 객체라면 true를 리턴하고, 다른 객체라면 false를 리턴한다( == 과 동일)
    Object obj1 = new Object();
    Object obj2 = obj1;
    boolean result1 = obj1.equals(obj2); // true
    boolean result2 = (obj1 == obj2); // true
    ```

* Object의 equals()메서드와 hashCode()메서드는 객체의 번지(메모리 주소)값을 비교하기 때문에 보통, 오버라이드(메서드 재정의)해서 데이터에 대한 동등 비교용으로 사용한다.

* 동등 비교란?
    * 객체가 비록 달라도 **내부의 데이터가 같은지**를 비교하는 것을 말함
    예) String은 equals()메서드를 재정의해서 내부 문자열이 같은지를 비교함

* 개발자가 만든 사용자 정의 클래스에서 equals()메서드와 hashCode()메서드를 
오버라이드 하지 않으면 Object클래스의 객체의 번지를 비교하는 equals()와 hashCode()로
작동하기 때문에, 내부 값의 동등 비교가 필요할 땐 반드시 오버라이드를 해야한다.

## hashCode()
* 객체 해시코드란 객체를 식별하는 정수를 말함.
Object클래스의 hashCode()는 객체의 메모리 번지를 이용해서 해시코드(객체를 식별하는 정수)를 생성해서 리턴. 그래서 객체마다 다른 정수값을 리턴하는데, 
equals()와 마찬가지로 두 객체가 동등한지를 비교할 때 주로 사용함
(내부 데이터 비교 X, 객체의 메모리 번지 -> 정수화 동등 비교)

그래서, equals()메서드와 마찬가지로 hashCode()메소드 역시 객체의 데이터를 비교해서
동등비교 되도록 오버라이드 하는 경우가 일반적.
객체가 다르다 해도 내부 데이터가 동일하면 **같은 정수값을 리턴**하기 위해.

```java
public int hashCode()
```

자바는 두 객체가 동등함을 비교할 때 hashCode()와 equals()메서드를 같이 사용
우선 hashCode()가 리턴하는 정수 값이 같은지를 확인하고,
그 다음 equals()메서드가 true를 리턴하는지를 확인해서 동등 객체임을 판단.
equals()만 오버라이드 하면 HashSet, HashMap같은 컬렉션에서 문제 발생.






