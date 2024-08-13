package com.xuhh.foundation.juc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class App {
  public  static   int count=0;
  public static  Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        linux();
        aix();
        kafka();
        rabbitmq();
        rocketmq();
        System.out.println("activemq的数量 = " + 1);
        windows();
        mongodb();
        oracle();
        zookeeper();
        System.out.println((1 << 16) - 1);
    };

    private static  void  linux(){
    String gongyouyun="system.os.nofile.used_pct\n" +
            "system.os.nofile.current\n" +
            "log.keyword.hit\n" +
            "system.io.await\n" +
            "system.fs.inodes.in_use\n" +
            "system.disk.readonly\n" +
            "system.net.packets_out.error\n" +
            "system.net.packets_in.count\n" +
            "system.net.bytes_sent\n" +
            "system.net.packets_in.error\n" +
            "system.net.packets_out.count\n" +
            "vstationd.status\n" +
            "system.processes.gc.InfoCount.FGCT\n" +
            "hcbsClient.status\n" +
            "vpcMonitor.status\n" +
            "hcbsAgent.status\n" +
            "dfwAgent.status\n" +
            "system.processes.status\n" +
            "vpcAgent.status\n" +
            "system.processes.number\n" +
            "system.process.zombie.num\n" +
            "hostNetDaemon.status\n" +
            "moa.status\n" +
            "dns.status\n" +
            "crond.status\n" +
            "ping.lost.percent\n" +
            "ntp_service.status";
    String siyouyun="system.load.5\n" +
            "CCBA.linux.CPU.CpuLoad.1min\n" +
            "system.cpu.pct_usage\n" +
            "system.cpu.system\n" +
            "system.cpu.iowait\n" +
            "CCBA.Linux.NVME.Percentage_Used\n" +
            "CCBA.Linux.NVME.Available_Spare\n" +
            "CCBA.Linux.NVME.Warning_Temperature_Time\n" +
            "CCBA.Linux.NVME.Critical_Warning\n" +
            "CCBA.Linux.NVME.Media_Errors\n" +
            "system.swap.used_pct\n" +
            "CCBA.Linux.NTP_SOURCESTATUE\n" +
            "CCBA.linux.NTP.OFFSET\n" +
            "CCBA.LINUX.sanlinkfailedCount\n" +
            "CCBA.Linux.MEM.MemFree\n" +
            "system.os.nofile.used_pct\n" +
            "log.keyword.hit\n" +
            "system.io.await\n" +
            "system.fs.inodes.in_use\n" +
            "system.disk.pct_usage\n" +
            "system.net.packets_out.error\n" +
            "system.net.packets_in.error\n" +
            "system.net.bandwidth.used_pct\n" +
            "system.process.noroot.num\n" +
            "system.processes.number\n" +
            "system.process.zombie.num\n" +
            "CCBA.linux.ULIMITS.NPROC\n" +
            "CCBA.LINUX.CronQueue";

    String hefei ="system.cpu.pct_usage\n" +
            "system.cpu.pct_usage\n" +
            "system.cpu.pct_usage\n" +
            "system.mem.pct_usage\n" +
            "system.swap.used_pct\n" +
            "system.mem.pct_usage\n" +
            "system.swap.used_pct\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "system.disk.pct_usage\n" +
            "\n" +
            "\n" +
            "system.fs.inodes.in_use\n" +
            "itsm.entegoragent.status\n" +
            "system.tcp.time_wait\n" +
            "system.udp.connect.num\n" +
            "system.tcp.time_wait\n" +
            "system.udp.connect.num\n" +
            "system.tcp.time_wait\n" +
            "system.udp.connect.num\n" +
            "system.os.nofile.used_pct\n" +
            "system.thread.pct_usage\n" +
            "system.cpu.pct_usage\n" +
            "system.cpu.pct_usage\n" +
            "system.disk.pct_usage\n" +
            "\n" +
            "system.fs.inodes.in_use\n" +
            "system.tcp.time_wait\n" +
            "system.udp.connect.num\n" +
            "system.mem.pct_usage\n" +
            "system.swap.used_pct\n" +
            "system.disk.pct_usage\n" +
            "\n" +
            "system.fs.inodes.in_use\n" +
            "system.mem.pct_usage\n" +
            "system.swap.used_pct\n" +
            "system.ping.delay\n" +
            "system.cpu.pct_usage\n" +
            "bastion.service.count.port\n" +
            "bastion.service.count.process\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "ping.can_connect\n" +
            "system.cpu.pct_usage\n" +
            "system.disk.pct_usage\n" +
            "system.mem.pct_usage\n" +
            "ibmmq.queue.info.curdepth\n" +
            "ibmmq.channel.count.running\n" +
            "ibmmq.channel.status.running\n" +
            "ibmmq.queue.info.curdepth\n" +
            "custom.process.noperiod.count\n" +
            "custom.process.count\n" +
            "custom.process.pgsql.archiver.failed\n" +
            "custom.linux.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "ibmmq.channel.count.running\n" +
            "ibmmq.channel.status.running\n" +
            "ibmmq.queue.info.curdepth\n" +
            "system.processes.status\n" +
            "itsm.entegoragent.status.nocolumns\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "custom.linux.disk.pct_usage\n" +
            "system.tcp.close_wait\n" +
            "system.tcp.time_wait\n" +
            "system.udp.connect.num";
    String yizhuang="eureka.jvm.memory.used\n" +
            "eureka.local_connect\n" +
            "eureka.jvm.memory.used\n" +
            "eureka.jvm.memory.used\n" +
            "eureka.jvm.memory.used\n" +
            "eureka.jvm.memory.used";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("linux的数量 = " + set.size());
    }
    private static  void  aix(){
    String gongyouyun="";
    String siyouyun="system.load.norm.15\n" +
            "system.cpu.idle\n" +
            "aix.healthcheck.cpupool\n" +
            "aix.healthcheck.vcpu\n" +
            "system.disk.pct_usage\n" +
            "aix.healthcheck.ntp\n" +
            "aix.healthcheck.ntpoffset\n" +
            "system.mem.pct_usage\n" +
            "aix.healthcheck.crontab\n" +
            "system.disk.mount\n" +
            "system.net.status\n" +
            "system.errpt.hardware";
    String hefei ="system.cpu.pct_usage\n" +
            "system.mem.pct_usage\n" +
            "system.paging.used_pct\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "system.net.status\n" +
            "system.tcp.time_wait";
    String yizhuang="system.tcp.time_wait\n" +
            "system.net.status\n" +
            "system.disk.pct_usage\n" +
            "system.fs.inodes.in_use\n" +
            "system.fs.inodes.used\n" +
            "system.mem.pct_usage\n" +
            "system.paging.used_pct\n" +
            "system.cpu.pct_usage\n" +
            "alert.file.monlog";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("aix的数量 = " + set.size());
    }

    private static  void  kafka(){
        String gongyouyun="";
        String siyouyun="kafka.can_connect";
        String hefei ="kafka.messages_in.rate\n" +
                "kafka.topic.messages_in.rate\n" +
                "kafka.messages_in.rate\n" +
                "kafka.topic.messages_in.rate\n" +
                "kafka.net.bytes_in.rate\n" +
                "kafka.topic.net.bytes_in.rate\n" +
                "kafka.messages_in.rate\n" +
                "kafka.topic.messages_in.rate\n" +
                "kafka.consumer_lag\n" +
                "kafka.net.bytes_in.rate\n" +
                "kafka.topic.net.bytes_in.rate\n" +
                "kafka.net.bytes_in.rate\n" +
                "kafka.topic.net.bytes_in.rate\n" +
                "kafka.net.bytes_in.rate\n" +
                "kafka.topic.net.bytes_in.rate\n" +
                "kafka.request.fetch_consumer.time.avg\n" +
                "kafka.can_connect\n" +
                "kafka.messages_in.rate\n" +
                "kafka.topic.messages_in.rate\n" +
                "kafka.request.fetch_consumer.time.avg";
        String yizhuang="";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("kafka的数量 = " + set.size());
    }
    private static  void  rabbitmq(){
        String gongyouyun="rabbitmq.aliveness";
        String siyouyun="";
        String hefei ="rabbitmq.node.fd_used\n" +
                "rabbitmq.node.sockets_used\n" +
                "rabbitmq.instance.local_connect\n" +
                "rabbitmq.node.fd_used\n" +
                "rabbitmq.node.sockets_used\n" +
                "rabbitmq.aliveness\n" +
                "rabbitmq.instance.connections\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "rabbitmq.queue.messages_ready\n" +
                "rabbitmq.queue.messages_unacknowledged\n" +
                "custom.rabbitmq.node.mem_used_pct\n" +
                "rabbitmq.queue.messages_ready\n" +
                "\n" +
                "\n" +
                "rabbitmq.node.partitions\n" +
                "custom.rabbitmq.instance.local_connect\n" +
                "custom.rabbitmq.node.mem_used_pct";
        String yizhuang="";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("rabbitmq的数量 = " + set.size());
    }
    private static  void  rocketmq(){
        String gongyouyun="rabbitmq.aliveness";
        String siyouyun="";
        String hefei ="rocketmq.broker.msg.get.10min\n" +
                "rocketmq.broker.msg.get.1min\n" +
                "rocketmq.broker.msg.put.10min\n" +
                "rocketmq.broker.msg.put.1min\n" +
                "rocketmq.broker.msg.get.10min\n" +
                "rocketmq.broker.msg.get.1min\n" +
                "rocketmq.broker.msg.put.10min\n" +
                "rocketmq.broker.msg.put.1min\n" +
                "rocketmq.consumer.msg.diff_by_topic_broker_queue\n" +
                "rocketmq.consumer.msg.diff_by_topic_broker_queue\n" +
                "rocketmq.consumer.msg.diff_by_topic_broker_queue";
        String yizhuang="";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("rocketmq的数量 = " + set.size());
    }
    private static  void  windows(){
        String gongyouyun="system.cpu.pct_usage\n" +
                "system.proc.count";
        String siyouyun="system.cpu.user\n" +
                "system.cpu.pct_usage\n" +
                "system.cpu.system\n" +
                "system.mem.pct_usage\n" +
                "system.disk.pct_usage\n" +
                "windows_service.state";
        String hefei ="system.cpu.pct_usage\n" +
                "system.mem.pct_usage\n" +
                "system.disk.pct_usage";
        String yizhuang="system.disk.pct_usage\n" +
                "system.disk.partition.use.pct_usage\n" +
                "system.mem.pct_usage\n" +
                "system.cpu.pct_usage";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("windows的数量 = " + set.size());
        System.out.println(set);
    }
    private static  void  mongodb(){
        String gongyouyun="";
        String siyouyun="mongodb.asserts.warningps\n" +
                "mongodb.connections.current\n" +
                "mongodb.connections.available\n" +
                "mongodb.globallock.currentqueue.writers\n" +
                "mongodb.globallock.activeClients.writers\n" +
                "mongodb.globallock.activeClients.readers\n" +
                "mongodb.globallock.currentqueue.readers\n" +
                "mongodb.lastWrite.majority.ts.later";
        String hefei ="mongodb.can_connect\n" +
                "mongodb.repl.node.health";
        String yizhuang="mongodb.can_connect\n" +
                "mongodb.repl.node.health";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("mongodb的数量 = " + set.size());
        System.out.println(set);
    }
    private static  void  oracle(){
        String gongyouyun="oracle.base.current.connections\n" +
                "oracle.can_connect\n" +
                "oracle.tablespace.used.percentage";
        String siyouyun="oracle.adg.Ora_DG_ScnLag\n" +
                "oracle.adg.TransLag\n" +
                "oracle.adg.ApplyLag\n" +
                "oracle.mrp.status\n" +
                "oracle.adg.FlashUsage\n" +
                "oracle.crs.status\n" +
                "oracle.asmdisk.status\n" +
                "oracle.sysdisk.count\n" +
                "oracle.asmdisk.votingfile\n" +
                "oracle.diskgroup.status\n" +
                "oracle.diskgroup.failgroup\n" +
                "oracle.session.blktime\n" +
                "oracle.session.pga\n" +
                "oracle.session.grtwk\n" +
                "oracle.session.temp\n" +
                "oracle.undo.pctused\n" +
                "oracle.tablespace.status\n" +
                "oracle.tmptbs.pctused\n" +
                "oracle.tbs.pctused\n" +
                "oracle.session.ProcUsed\n" +
                "oracle.database.blkerr\n" +
                "oracle.arch.used\n" +
                "oracle.instance.status\n" +
                "oracle.instance.hang\n" +
                "oracle.session.SessUsed\n" +
                "oracle.instance.txevent\n" +
                "oracle.sequence.sequsage\n" +
                "oracle.datafile.state\n" +
                "msg_minor.alert\n" +
                "msg_major.alert\n" +
                "oracle.listener.connect\n" +
                "oracle.tcp.count\n" +
                "oracle.gcblock.lost";
        String hefei ="oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.redo.active_current.pct\n" +
                "oracle.tbs.used_pct\n" +
                "custom.oracle.crs.res\n" +
                "oracle.crs.res\n" +
                "\n" +
                "\n" +
                "oracle.instance.core_process\n" +
                "oracle.local_connect\n" +
                "oracle.rac.process.used_pct\n" +
                "oracle.rac.session.used_pct\n" +
                "oracle.asm.diskgroup.state\n" +
                "oracle.asm.disk.state\n" +
                "oracle.datafile.status\n" +
                "oracle.index.unusable.count\n" +
                "oracle.base.current.connections\n" +
                "oracle.can_connect\n" +
                "oracle.tablespace.used.percentage";
        String yizhuang="custom.oracle.crs.res\n" +
                "oracle.crs.res\n" +
                "\n" +
                "oracle.instance.core_process\n" +
                "oracle.local_connect\n" +
                "oracle.asm.diskgroup.state\n" +
                "oracle.asm.disk.state\n" +
                "oracle.datafile.status\n" +
                "oracle.index.unusable.count\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.rac.process.used_pct\n" +
                "oracle.rac.session.used_pct\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.disk.group.usage_pct\n" +
                "oracle.can_connect\n" +
                "oracle.tablespace.used.percentage\n" +
                "custom.oracle.crs.res\n" +
                "oracle.crs.res\n" +
                "\n" +
                "oracle.has.svc\n" +
                "oracle.instance.core_process\n" +
                "oracle.local_connect\n" +
                "oracle.asm.disk.group.usage_pct\n" +
                "oracle.can_connect\n" +
                "oracle.tablespace.used.percentage\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "\n" +
                "\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.diskgroup.used_pct\n" +
                "oracle.datafile.used_pct\n" +
                "oracle.tbs.used_pct\n" +
                "oracle.asm.disk.group.usage_pct\n" +
                "oracle.can_connect\n" +
                "oracle.tablespace.used.percentage";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("oracle的数量 = " + set.size());
        System.out.println(set);
    }
    private static  void  zookeeper(){
        String gongyouyun="zookeeper.connections\n" +
                "zookeeper.latency.min\n" +
                "zookeeper.latency.avg\n" +
                "zookeeper.latency.max\n" +
                "zookeeper.ruok";
        String siyouyun="zookeeper.nodes\n" +
                "zookeeper.latency.min\n" +
                "zookeeper.latency.avg\n" +
                "zookeeper.latency.max\n" +
                "log.keyword.hit\n" +
                "zookeeper.ruok";
        String hefei ="";
        String yizhuang="";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("zookeeper的数量 = " + set.size());
    }



    private static  void  moudle(){
        String gongyouyun="";
        String siyouyun="";
        String hefei ="";
        String yizhuang="";
        Set<String> set = new HashSet<>();
        String s = gongyouyun + "\n" + siyouyun + "\n" + hefei + "\n" + yizhuang + "\n";
        Arrays.stream(s.split("\n")).forEach(arg->{
            if (null == arg || StringUtils.isEmpty(arg.trim())) {
                return;
            }
            arg=arg.trim();
            set.add(arg);
        });
        System.out.println("kafka的数量 = " + set.size());
    }

}
