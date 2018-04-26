export class History {
    serial_number: number;
    collaborator_name: string;
    type: string;
    date: number;
    store_name: string;


    constructor(){
       this.serial_number = 0;
       this.collaborator_name = "";
       this.type = "";
       this.date = 0;
       this.store_name = "";
    }
}