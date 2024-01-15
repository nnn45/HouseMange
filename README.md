# 房源管理系统

# 一、引言

**  ** 本实验旨在通过设计和实现一个房源管理系统，提高房地产中介机构或个人对房源的管理效率，实现房源信息的规范化、系统化存储和查询，提高房源信息的利用率。同时，通过本次实验，希望能够深入了解和掌握相关的技术和工具，为未来的工作和实践打下坚实的基础。实验环境为个人计算机，操作系统为Windows 10，开发工具为Eclipse&IDEA，数据库为MySQL。

# 二、需求分析

房源信息录入：系统应支持房源信息的录入，包括房屋类型、面积、价格、位置等详细信息。
房源信息查询：系统应提供多种查询方式，如按房屋类型、、名称、位置等条件进行查询，并显示查询结果。
房源信息修改：系统应支持对已有的房源信息进行修改，包括房屋类型、面积、价格、位置等详细信息。
房源信息删除：系统应支持对已有的房源信息进行删除操作。
房源类型信息录入：系统应支持房源类型信息的录入，包括房屋类型名称 、解释等详细信息。
房源类型信息查询：系统应提供查询方式，按类型名称进行查询，并显示查询结果。
房源类型信息修改：系统应支持对已有的房源类型信息进行修改，包括房屋类型名称 、解释等详细信息。
房源类型信息删除：系统应支持对已有的房源类型信息进行删除操作。
用户操作：系统应支持用户进行登录、退出操作。

# 三、总体设计

## 1、主模块

(1)房源信息管理模块
房源信息录入
房源信息查询
房源信息修改
房源信息删除
(2)房源类型管理模块
房源类型信息录入
房源类型信息查询
房源类型信息修改
房源类型信息删除
(3)用户操作模块
用户登录
用户退出

## 2、模块之间的关系

房源信息管理模块与房源类型管理模块：这两个模块之间存在数据关联。当录入房源信息时，可以选择对应的房源类型。因此，房源类型的录入和管理是房源信息管理的基础。
用户操作模块与其他模块：用户操作模块为其他模块提供了用户界面，使得用户可以登录系统、退出系统，并使用其他功能。
房源信息管理模块与用户操作模块：用户通过用户操作模块进入房源信息管理模块，进行房源信息的录入、查询、修改、删除等操作。
房源类型管理模块与用户操作模块：用户通过用户操作模块进入房源类型管理模块，进行房源类型信息的录入、查询、修改、删除等操作。

## 3、 依赖关系

房源信息管理模块依赖于房源类型管理模块：因为在进行房源信息录入时，需要选择相应的房源类型。所以，房源类型信息的存在是房源信息管理的基础。
所有模块都依赖于用户操作模块：用户操作模块为其他所有模块提供了用户界面和交互功能，使得用户可以与系统进行交互。

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301423580-7fc830a5-1024-4fd4-bcca-e6383b61474c.png#averageHue=%23f9f8f6&height=243&id=CxcbY&originHeight=511&originWidth=874&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=416)

# 四、数据库设计

数据库E-R图如下：

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301423853-f29bbd66-ba7c-4226-9925-8689f6605698.png#averageHue=%23fcfcfc&height=286&id=Hf9t9&originHeight=770&originWidth=918&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=341)

系统用例图如下：

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301424111-e3f4d2e8-5c35-4b73-a7fe-b1abfd11dc5f.png#averageHue=%23fcfcfc&height=312&id=lj531&originHeight=789&originWidth=811&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=321)

用户表结构如下：

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301424427-81e7b1b5-08c8-4d56-9e7b-7706bb86272f.png#id=iUNhL&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=415)

房源信息表结构如下：

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301424657-45e747bc-5abf-4dd6-a76b-efa01c44cb82.png#id=e62Ch&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=416)

房源类型表结构如下：

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301424930-9f72d3c9-d6dc-484b-b41f-866cb305cb98.png#id=fi6XF&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=415)

# 五、系统实现

![image.png](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705302050740-7632c1ca-e389-47ef-905a-c9fd96e6ce9f.png#averageHue=%234e555e&clientId=ub476ab5d-55ec-4&from=paste&height=1035&id=ud6c918cc&originHeight=1035&originWidth=1920&originalType=binary&ratio=1&rotation=0&showTitle=false&size=237716&status=done&style=none&taskId=u7918b1e5-1a3f-4864-9be5-a1ee91f5024&title=&width=1920)

## 5.1房源信息管理模块

5.1.1房源信息录入

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301425154-27d6a4f1-c2b1-46b2-a573-cee888099844.png#averageHue=%233f4244&height=377&id=IYYEm&originHeight=556&originWidth=439&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=298)

5.1.2房源信息查询

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301426293-6f94300a-98f9-4773-a3fd-8890a766dcc4.png#averageHue=%23404345&height=218&id=jQLkI&originHeight=395&originWidth=753&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=416)

5.1.3房源信息修改

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301427077-504eecc2-a9a2-4288-80ae-e498a3aca81a.png#averageHue=%23404345&height=176&id=fSI7k&originHeight=316&originWidth=747&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=416)

5.1.4房源信息删除

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301428315-93c4b756-3e0b-4b72-8dcc-004c09063988.png#id=OequS&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=416)

## 5.2房源类型管理模块

5.2.1房源类型信息录入

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301428968-41837654-b04e-4775-9abd-93ede5a9d12f.png#averageHue=%233d4042&height=286&id=lTfJ7&originHeight=381&originWidth=525&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=394)

5.2.2房源类型信息查询

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301429705-bc3bb319-768c-4593-a7ad-2a008006db7d.png#averageHue=%23404345&height=230&id=iTzP3&originHeight=307&originWidth=469&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=352)

5.2.3房源类型信息修改

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301430452-35818106-abc3-4a76-8d58-3a9d6d1f9323.png#averageHue=%233f4345&height=191&id=PAE99&originHeight=254&originWidth=446&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=335)

5.2.4房源类型信息删除

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301431229-2a9c0a27-4884-46e9-b442-fb1485ce93b0.png#averageHue=%233e4244&height=416&id=NeKPO&originHeight=554&originWidth=477&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=358)

## 5.3用户操作模块

5.3.1用户登录

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301432061-7ec9dd27-c79e-423a-9338-8de8267dff89.png#averageHue=%233d4043&height=185&id=zKNXU&originHeight=359&originWidth=492&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=254)

5.3.2用户退出

![](https://cdn.nlark.com/yuque/0/2024/png/40370161/1705301432844-dcaaf575-ef38-43e1-b580-112959762168.png#averageHue=%233d434e&height=88&id=KCWCc&originHeight=117&originWidth=357&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=268)

