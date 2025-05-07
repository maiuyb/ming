# 问题：手电筒与电池系统设计

## 题目描述

你需要设计一个简化版的**手电筒与电池系统**，其中手电筒依赖电池供电，电池可以被充电或者被消耗电量。

系统中包含两个类：`Battery`（电池）和 `Torch`（手电筒）。部分代码已经提供，你需要补全缺失的方法，使系统按照要求正常工作。

## 类说明

### Battery 类（电池）

用于模拟一个可充电电池。

#### 属性

- `double power`：当前电池电量，范围为 [0.0, 1.0]。
- `double consumptionRate`：每小时消耗的电量百分比。
- `double productionRate`：每小时充入的电量百分比。

#### 构造方法

- `Battery()`：无参构造方法，初始化默认值：
  - 电量 power = 0.0
  - 消耗速率 consumptionRate = 0.1
  - 充电速率 productionRate = 0.2

- `Battery(double cRate, double rRate)`：构造方法，使用指定的消耗率和充电率初始化。

#### 成员方法

- `double getConsumptionRate()`：返回消耗速率。
- `double getProductionRate()`：返回充电速率。

- `void chargeBattery(double p)`：向电池充入 p 单位电量。
  - 若充电后电量超过 1.0，设为 1.0。

- `boolean useBattery(double p)`：尝试消耗 p 单位电量。
  - 如果当前电量 ≥ p，减去并返回 `true`；
  - 否则将电量清零并返回 `false`。

---

### Torch 类（手电筒）

用于模拟一只依赖电池供电的手电筒。

#### 构造方法

- `Torch(Battery battery)`：使用给定电池初始化手电筒。

#### 成员方法

- `boolean turnOn(int hours)`：尝试打开手电筒指定小时数。
  - 每小时耗电 10%（即使用 `battery.getConsumptionRate()`）。
  - 若电量充足，返回 `true`，否则返回 `false`。

- `void charge(int hours)`：给电池充电指定小时数。
  - 每小时充电 20%（即使用 `battery.getProductionRate()`）。
  - 电量不得超过 1.0。

---

## 编程任务

请你根据上述类的说明，**补全缺失的方法实现**，使手电筒与电池系统能够按预期运行。你无需修改类结构，仅需补全方法体。

---

## 限制条件

- 所有电量值均为 [0.0, 1.0] 之间的双精度浮点数。
- 输入参数均为非负数，无需进行额外输入校验。
- 浮点数精度问题无需考虑，正常使用 `double` 类型计算即可。

---

## 示例

```java
Battery b = new Battery();
Torch t = new Torch(b);

t.charge(3);                 // 电池电量增加至 0.6
System.out.println(t.turnOn(5));  // true，耗电 0.5
System.out.println(t.turnOn(2));  // false，剩余电量不足 0.2