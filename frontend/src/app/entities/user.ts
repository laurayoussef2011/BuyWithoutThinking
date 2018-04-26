export class User {
    name: string ;
    username: string;
    email: string ;
    password: string;
    type: string;
    storename: string;
    credit: number;


     constructor (){
        this.name="";
        this.username="";
        this.email="";
        this.password="";
        this.type="NormalUser";  
        this.storename ="";
        this.credit = 10000;

    }

    setter (_name:string , _username: string,_email: string ,_password: string,_type:string,_storename:string , _credit:number){
        this.name=_name;
        this.username=_username;
        this.email=_email;
        this.password=_password;
        this.type=_type; 
        this.storename = _storename;
        this.credit = _credit;
 
    }
}
