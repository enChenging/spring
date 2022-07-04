package com.release.demo01;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class Proxy {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent(){
        seeHouse();
        host.rent();
        charge();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带看房");
    }

    //收中介费
    public void charge(){
        System.out.println("收中介费");
    }
}
