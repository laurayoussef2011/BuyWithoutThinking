export class Product {
    serialnumber: number;
    productname: string;
    storename: string;
    price: number;
    model: string;
    brand: string;
    views: number;
    quantity: number
    available : boolean;


    constructor (){
        this.serialnumber=-1;
        this.productname="";
        this.storename="";
        this.price=0;
        this.model="";
        this.brand="";
        this.views=0;
        this.quantity=0;
        this.available=true;
      
    }
}