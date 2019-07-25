/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : program_take

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-07-03 15:49:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` mediumtext,
  `commentNumber` int(11) DEFAULT NULL,
  `pointsNumber` int(11) DEFAULT NULL,
  `browseNumber` int(11) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `topStatus` int(11) DEFAULT NULL,
  `hotStatus` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `cid` (`cid`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('25', 'JS div匀速移动动画与变速移动动画', '<h1>1. 引言</h1><p>一般我们写论文插入参考文献的标号都是手动输入的，这样造成的问题有以下几个：</p><ol><li>手动输入标号比较麻烦；</li><li>如果参考文献顺序变了，需要一个一个重新更改标号数值，及其麻烦；</li><li>标号无法和末尾的参考文献链接起来。</li></ol><p>下面介绍正确的操作方法。</p><p><br></p><img width=\"500\" height=\"300\" src=\"/upload/273-45e7-be35-66f9b7f5164b.png\"><p><h1>3. 锦上添花</h1>设想一个场景，你的文章已经写了60页，而你正在第6页的某一段插入参考文献，那么你需要在第6页编辑的地方和文章末尾参考文献正文之间来回跳转，非常麻烦，有没有什么办法可以快速定位两个位置，实现一键跳转？<br><br>其实，用好插入 &gt; 书签功能就好了。<br><br>版权声明：本文为博主原创文章，转载请附上博文链接！</p>', '0', '0', '15', '2019-03-03', '0', '1', '1', '13', '1');
INSERT INTO `article` VALUES ('26', 'css', '<p><strong>css预处理器</strong></p><p>CSS预处理器定义了一种新的语言，用一种专门的编程语言，减少枯燥无味的CSS代码的编写过程的同时，它能让你的CSS具备更加简洁、适应性更强、可读性更加、层级关系更加明显、更易于代码的维护等诸多好处。</p><p>sass使用<br><br>.scss文件转化的css代码<br>sass input.scss:output.css<br>监视单个 sass 文件，每次修改并保存时自动编译：<br>sass --watch input.scss:output.css<br><br>sass编译风格<br><br>nested：嵌套缩进的css代码，它是默认值。<br>expanded：没有缩进的、扩展的css代码。<br>compact：简洁格式的css代码。<br>compressed：压缩后的css代码。<br>生产环境中一般使用最后一种风格：<br>sass --style compressed test.scss:test.css<br>sass --watch --style compressed test.scss:test.css<br><br></p><img width=\"500\" height=\"300\" src=\"/upload/7a5-4a4a-a831-83e6ac5f3ed6.png\">', '0', '1', '150', '2019-03-03', '1', '1', '1', '13', '1');
INSERT INTO `article` VALUES ('27', 'Java程序设计：五子棋（二）添加棋子', '<h1>如何添加棋子</h1><p>我们平时也在不同平台上玩过类似的棋盘游戏，一般的棋盘游戏的玩法都是在你想下的位置点一下，系统就会在你点的位置下一个棋子。五子棋的棋盘很规则，都是一个个正方形格子，点一个位置便会在那附近的格子角下一颗棋子。<br><br>那么怎么判断是哪个角呢？一般简单的定义一下就能解决。以一个格子为例，假设点在这个格子中，位置为(x,y)，而这个格子的某个顶点位置已知（一般是左上角），比如左上角位置为(a,b)，格子边长为l，那么把格子横着竖着平均分成四份，分别对应四个角即可：<br>--------------------- <br></p><img width=\"500\" height=\"300\" src=\"/upload/8ff-444b-8c2f-b4f65fc9af64.png\">', '0', '0', '5', '2019-03-03', '0', '0', '1', '12', '3');
INSERT INTO `article` VALUES ('28', 'Unity', '<p>在同一个镜头中，canvas中所有的物体在进行渲染时，会按照先后顺序，即后渲染的会遮住先渲染的。因此在设定一些比如按钮的遮挡关系的时候。可以将想要在最上层的UI放到最后去渲染，修改Hierarchy层级面板从上往下的顺序。 <br>举个例子： <br> 将gameover放到最上面时，就会被挡到。<br>--------------------- <br><br></p><img width=\"500\" height=\"300\" src=\"/upload/46e-4651-9794-3795274dfabd.png\">', '0', '0', '3', '2019-03-03', '0', '0', '1', '12', '3');
INSERT INTO `article` VALUES ('29', '等额本息代码过程', '<p>在假设贷款总额是A，而每月利息是b，总共360期，目标是计算每个月应该给银多少钱，推导过程如下。</p><p><br>设每个月还银行的本金为<br>mn(1≤n≤360) m_n ( 1 \\leq n \\leq 360)<br>m <br>n<br>	<br> (1≤n≤360)<br><br>每个月还给银行的本金加上利息设为c，则每月的c是固定的。<br><br>现在分析一下第i个月的还款情况，前面i-1个月已经还了本金∑i−1n=1mn \\sum_{n=1}^{i - 1} m_{n}∑ <br>	<br> ，故此时只欠银行的本金为：A−∑i−1n=1mn A - \\sum_{n=1}^{i - 1} m_{n}A−∑ <br>	<br> ，所本月应还的利息是：(A−∑i−1n=1mn)b (A - \\sum_{n=1}^{i - 1} m_{n})b(A−∑ <br>n=1<br>i−1<br>&nbsp; &nbsp;&nbsp;<br>	<br> )b，c应该是利息加上应还有本金，故有：<br><br>c=(A−∑i−1n=1mn)b+mi,1≤i≤360(式1) c = (A - \\sum_{n = 1} ^ {i-1}m_{n})b + m_{i}, 1 \\leq i \\leq 360 (式1)<br> )b+m <br>i<br>	<br> ,1≤i≤360(式1)<br><br>当还完第360个月之后，应该不再欠银行钱了，于是有：<br>A−∑360n=1mn=0(式2) A - \\sum_{n=1}^{360}m_{n} = 0 (式2)<br><br> =0(式2)<br><br>当式1取i = 360时，联合式2即有：<br>c=(A−∑359n=1mn)b+m360 c = (A - \\sum_{n=1}^{359} m_{n})b + m_{360}</p><p><br><br></p>', '0', '1', '31', '2019-03-03', '1', '0', '1', '13', '4');
INSERT INTO `article` VALUES ('30', '怎么理解深度学习中的线性回归', '<p><h1>怎么理解？</h1><br>本文可以这样说都是“拿来”的，因为太阳底下没有新鲜事（ There is nothing new under the sun.）这句话的出处太多，不知选谁的，反正都是这句话。读书不仅仅是看作者是怎么说的，最重要的是自己的是怎么想的，所以本文会包含自己的想法。<br><br>鲁迅说：总之，我们要拿来。我们要或使用或存放，或毁灭。那么，主人是新主人，宅子也就会成为新宅子。然而首先要这人沉着，勇猛，有辨别，不自私。没有拿来的，人不能自成为新人，没有拿来的，文艺不能自成为新文艺。<br><br>作为拿来者鲁迅的意见是这样的“拿来”者应具有的素质：“沉着、勇猛、有辨别、不自私”。<br>对待态度是首先是“占有”，然后是“挑选”。<br>--------------------- <br><br></p><img width=\"500\" height=\"300\" src=\"/upload/d63-4af7-ba89-dbc7477c6406.png\">', '0', '1', '4', '2019-03-03', '0', '0', '1', '13', '4');
INSERT INTO `article` VALUES ('31', '开源Android容器化框架', '<p><h1>Atlas是什么？</h1><br>Atlas是一个Android客户端容器框架，主要提供了组件化、动态性、解耦化的支持。支持在编码期、Apk运行期以及后续运维修复期的各种问题。<br><br>在工程期，实现工程独立开发，调试功能，工程模块的独立。<br><br>在运行期间，实现完整的组件生命周期映射，类隔离等机制。<br><br>在运维期间，提供快速增量的更新修复功能，快速升级。<br><br>Atlas是工程期和运行期共同起作用的框架，它尽量将一些工作放在工程期，这样保证运行期的简单、稳定。<br>--------------------- <br><br></p><img width=\"500\" height=\"300\" src=\"/upload/a9d-4828-8b7a-49eb72133d08.png\">', '0', '0', '1', '2019-03-03', '0', '0', '1', '13', '2');
INSERT INTO `article` VALUES ('32', 'Spring框架详解 - 03', '<p><h1>前言</h1>Spring boot + Mybatis + Thymeleaf + Druid +mySql<br><br>&nbsp;&nbsp;&nbsp;&nbsp;开发环境（小编使用的版本）<br>&nbsp;&nbsp;&nbsp;&nbsp;JDK版本 ：1.8及以上 （JDK１.８）；<br>&nbsp;&nbsp;&nbsp;&nbsp;开发工具&nbsp;：Intellij IDEA （IDEA２０１８.２）；<br>&nbsp;&nbsp;&nbsp;&nbsp;服务器 ：Tomcat(务必比JDK版本高，小编不在解释（Jar包不用配置、War需要配置）)　（Tomcat９） ；<br>&nbsp;&nbsp;&nbsp;&nbsp;JRE包 ：Maven仓库 （Maven３.６）；<br>&nbsp;&nbsp;&nbsp;&nbsp;数据库 ：MySql（MySql５.５）&nbsp;；<br><h1>正题</h1>Spring boot ：2.１.１RELEASE ；<br><br>Thymeleaf<br><br>Mybatis<br><br></p><img width=\"500\" height=\"300\" src=\"/upload/649-4f0b-9a16-ba801e3c27ee.png\">', '0', '0', '1', '2019-03-03', '0', '0', '1', '14', '2');
INSERT INTO `article` VALUES ('33', 'nginx反向代理配置去除前缀', '<p>使用nginx做反向代理的时候，可以简单的直接把请求<a href=\"https://www.baidu.com/s?wd=%E5%8E%9F%E5%B0%81%E4%B8%8D%E5%8A%A8&amp;tn=24004469_oem_dg&amp;rsv_dl=gh_pl_sl_csd\" target=\"_blank\">原封不动</a>的转发给下一个服务。设置proxy_pass请求只会替换域名，</p><p>如果要根据不同的url后缀来访问不同的服务，则需要通过如下方法&nbsp;&nbsp;<br></p><p><br></p><img width=\"500\" height=\"300\" src=\"/upload/f29-473a-846b-243815491aae.png\"><p><code>^~/user/</code>表示匹配前缀是<code>user</code>的请求，<code>proxy_pass</code>的结尾有<code>/</code>， 则会把<code>/user/*</code>后面的路径直接拼接到后面，即移除<code>user</code>&nbsp;</p><ul><li>首先精确匹配&nbsp;<code>=</code></li><li>其次前缀匹配&nbsp;<code>^~</code></li><li>其次是按文件中顺序的正则匹配</li><li>然后匹配不带任何修饰的前缀匹配。</li><li>最后是交给&nbsp;<code>/</code>&nbsp;通用匹配</li><li>当有匹配成功时候，停止匹配，按当前匹配规则处理请求</li></ul><p>&nbsp;<br></p>', '0', '4', '14', '2019-03-03', '0', '0', '1', '16', '2');
INSERT INTO `article` VALUES ('34', 'vdfvfd', '<h1>dvfdvsfdvfd</h1><p>vvffdbfdb</p><p>brtrbmomtrn</p><p><br></p><img width=\"500\" height=\"300\" src=\"/upload/181-4751-b23a-c1b9309c0a2e.jpg\">', '0', '0', '5', '2019-03-04', '0', '0', '1', '12', '4');
INSERT INTO `article` VALUES ('36', '玩转js异步编程', '<h1>js异步</h1><p>一般知道，js脚步语言的执行环境是单线程的，就是它会等一个任务完成，才会进行第二个任务，然后一直向下进行，这样的执行环境简单，但是处理不了复杂的运用，<br>当一个请求需要非常旧的时间的时候，下一个流程就会被搁浅，如果长时间得不到反馈，进程就这样的奔溃了。为了解决这个硬性需求，Javascript语言提出了二种语言模式：同步（Synchronous）和 异步 （Asynchronous）。<br>异步的几种常用方法:回调函数，订阅和发布模式，Promise，generator，async/await</p><p><br></p><img width=\"500\" height=\"300\" src=\"/upload/a39-4475-89d0-8389da002d76.jpg\">', '0', '1', '4', '2019-03-12', '1', '0', '1', '18', '1');
INSERT INTO `article` VALUES ('37', '原生js实现简单日历的制作', '<h2>预览图</h2><p><br></p><img width=\"500\" height=\"300\" src=\"/upload/110-405f-be0e-baecc387ef11.png\"><h2>代码:</h2><p>for(var i=0;i&lt;7;i++)<br>{<br>	&nbsp;&nbsp;&nbsp;&nbsp;document.write(\"&lt;td&gt;\");<br>	&nbsp;&nbsp;&nbsp;&nbsp;document.write(weekday[i]);<br>	&nbsp;&nbsp;&nbsp;&nbsp;document.write(\"&lt;/td&gt;\");		<br>}</p><p><br></p><p><br></p><p><br></p>', '0', '0', '1', '2019-03-12', '0', '0', '1', '18', '1');
INSERT INTO `article` VALUES ('40', ' 深入理解vue', '<h1><strong>一 　理解vue的核心理念</strong></h1><p>使用vue会让人感到身心愉悦,它同时具备angular和react的优点,轻量级,api简单,文档齐全,简单强大,麻雀虽小五脏俱全.</p><p>倘若用一句话来概括vue,那么我首先想到的便是官方文档中的一句话:</p><p>Vue.js（读音 /vjuː/，类似于 view） 是一套构建用户界面的渐进式框架。</p><p>这句话可能大家并不陌生,但是真正理解这句话的可能并不多,其实,读懂了这句话,也就明白了vue的核心理念.<br><br>那么,怎样理解什么是渐进式框架?在这之前,我们首先要理解什么是框架.在最初的前端开发中,为了完成某个功能,我们需要通过js在HTML页面中获得dom节点,随后获得dom节点中的文本内容或者在dom节点上添加事件,进行一系列的程序操作,但是,如果任务量很大的情况下,代码会随着业务的增加而变得臃肿和混乱,在现实的开发中,负责的逻辑和巨大的开发量,是原生js无法完成的.<br><br>这个时候,开发人员将js代码分为了三个板块,数据(Model),逻辑控制(*),视图(View),数据板块只负责数据部分,视图板块负责更改样式,逻辑控制负责联系视图板块和数据板块,这样子有很大的好处,当需求发生变动时,只需要修改对应的板块就好<br><br></p><img width=\"500\" height=\"300\" src=\"/upload/5ae-48b5-9e1d-72d6833b44db.png\">', '0', '0', '0', '2019-03-12', '0', '0', '1', '20', '1');
INSERT INTO `article` VALUES ('41', 'nodejs介绍', '<p>nodejs是什么：<br><br>&nbsp; nodejs中文网中列出三条：<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.Node.js 是一个基于 Chrome V8 引擎的 JavaScript 运行环境。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.Node.js 使用了一个事件驱动、非阻塞式 I/O 的模型，使其轻量又高效。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.Node.js 的包管理器 npm，是全球最大的开源库生态系统。<br><br>它是一个运行时，既不是编程语言，也不是框架，是一个基于v8引擎的js运行环境，在nodejs中没有BOM与DOM，那是浏览器运行环境中的，nodejs中只包含JavaScript中的Ecmascript(变量、数组、方法、对象、函数等)，和自己的一些模块，这些模块使nodejs可以做服务器编程，如http模块，fs文件模块。<br><br>nodejs是单线程，但是它的非阻塞式编程，使得它非常高效<br><br>npm是node的包管理工具，和maven一样<br><br></p><img width=\"500\" height=\"300\" src=\"/upload/92a-4ab8-b439-b9daa5fc81f6.png\">', '0', '0', '0', '2019-03-12', '0', '0', '1', '20', '1');

-- ----------------------------
-- Table structure for audittable
-- ----------------------------
DROP TABLE IF EXISTS `audittable`;
CREATE TABLE `audittable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `adminMessage` varchar(255) DEFAULT NULL,
  `auditTime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  KEY `uid` (`uid`),
  CONSTRAINT `audittable_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`),
  CONSTRAINT `audittable_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audittable
-- ----------------------------
INSERT INTO `audittable` VALUES ('25', '13', '25', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('26', '13', '26', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('27', '12', '27', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('28', '12', '28', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('29', '13', '29', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('30', '13', '30', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('31', '13', '31', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('32', '14', '32', '1', '66', '2019-03-03');
INSERT INTO `audittable` VALUES ('33', '16', '33', '1', '6', '2019-03-03');
INSERT INTO `audittable` VALUES ('34', '12', '34', '1', 'tyh', '2019-03-04');
INSERT INTO `audittable` VALUES ('36', '18', '36', '1', 'buco', '2019-03-12');
INSERT INTO `audittable` VALUES ('37', '18', '37', '1', '66', '2019-03-12');
INSERT INTO `audittable` VALUES ('40', '20', '40', '1', '66', '2019-03-12');
INSERT INTO `audittable` VALUES ('41', '20', '41', '1', '66', '2019-03-12');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `visitCount` int(11) DEFAULT NULL,
  `postingCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '前端开发', '896', '0');
INSERT INTO `category` VALUES ('2', '后端开发', '443', '0');
INSERT INTO `category` VALUES ('3', '游戏开发', '732', '0');
INSERT INTO `category` VALUES ('4', '人工智能', '228', '0');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `aid` (`aid`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`aid`) REFERENCES `article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '29', '12', '2019-03-04');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uaid` int(11) DEFAULT NULL,
  `acontent` varchar(255) DEFAULT NULL,
  `ubid` int(11) DEFAULT NULL,
  `bcontent` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `repeatId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  KEY `uaid` (`uaid`),
  KEY `ubid` (`ubid`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`uaid`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`ubid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for concerns
-- ----------------------------
DROP TABLE IF EXISTS `concerns`;
CREATE TABLE `concerns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auid` int(11) DEFAULT NULL,
  `buid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auid` (`auid`),
  KEY `buid` (`buid`),
  CONSTRAINT `concerns_ibfk_1` FOREIGN KEY (`auid`) REFERENCES `user` (`id`),
  CONSTRAINT `concerns_ibfk_2` FOREIGN KEY (`buid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of concerns
-- ----------------------------

-- ----------------------------
-- Table structure for hot
-- ----------------------------
DROP TABLE IF EXISTS `hot`;
CREATE TABLE `hot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `aid` (`aid`),
  CONSTRAINT `hot_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `hot_ibfk_3` FOREIGN KEY (`aid`) REFERENCES `article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot
-- ----------------------------
INSERT INTO `hot` VALUES ('13', '26', '13', '2019-03-14');
INSERT INTO `hot` VALUES ('16', '25', '13', '2019-03-17');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '这是第一次公告!');

-- ----------------------------
-- Table structure for top
-- ----------------------------
DROP TABLE IF EXISTS `top`;
CREATE TABLE `top` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  KEY `uid` (`uid`),
  CONSTRAINT `top_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`),
  CONSTRAINT `top_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of top
-- ----------------------------
INSERT INTO `top` VALUES ('15', '36', '18', '2019-03-17');
INSERT INTO `top` VALUES ('16', '26', '13', '2019-03-17');
INSERT INTO `top` VALUES ('17', '29', '13', '2019-03-17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `headerImg` varchar(255) DEFAULT NULL,
  `articleCount` int(11) DEFAULT NULL,
  `jointime` date DEFAULT NULL,
  `desc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '18', '0', '123456', '/upload/default_admin.jpg', '0', '2019-01-30', '我是root...');
INSERT INTO `user` VALUES ('12', '守恒', '123', '25', '1', '34354353', '/upload/6a2-445a-9011-98b7703a543b.jpeg', '4', '2019-03-06', 'frfre');
INSERT INTO `user` VALUES ('13', '西安小沫', '123', '16', '1', '5768768', '/upload/abc-4737-a6bc-dc7a7f5dc075.jpeg', '5', '2019-02-15', '');
INSERT INTO `user` VALUES ('14', '小程序员', '123', '34', '0', '5663663', '/upload/default_user.jpeg', '1', '2019-01-11', null);
INSERT INTO `user` VALUES ('15', '四季凉飕飕', '123', '44', '0', '54654653', '/upload/default_user.jpeg', '0', '2019-03-07', null);
INSERT INTO `user` VALUES ('16', '老马', '123', '61', '1', '7884543', '/upload/d90-486b-b54f-f03a22089f54.png', '1', '2019-03-12', '');
INSERT INTO `user` VALUES ('18', '时光', '123', '17', '0', '12345678', '/upload/default_user.jpeg', '2', '2019-03-12', '');
INSERT INTO `user` VALUES ('20', '他说', '123', '56', '0', '1234567', '/upload/default_user.jpeg', '2', '2019-03-12', '');
