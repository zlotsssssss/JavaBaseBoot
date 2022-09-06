输入input：从磁盘、光盘数据读取到内存
输出output：从内存将数据输出到磁盘、光盘

JVM垃圾回收对物理连接资源，无法回收，数据库连接、输入输出连接、Socket网络连接

流分类：
操作单位：1.字节流（8bit、1byte，非文本数据）读取部分中文可能乱码，读取全部不会 InputStream OutputStream  
        2.字符流（.txt .c .cpp .java）包含中文也可以 用于文本传输  Reader  Writer 
流角色分类：1.节点流（未包装的流，fileInputStream，） 2.处理流（包装流，BufferFileInputStream），  
