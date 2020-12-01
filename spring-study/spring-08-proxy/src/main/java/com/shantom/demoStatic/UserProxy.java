package com.shantom.demoStatic;

public class UserProxy implements UserService{
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    private void log(String msg){
        System.out.println("调用了"+msg+"方法");
    }
}
