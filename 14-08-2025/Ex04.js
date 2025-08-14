class BankAccount 
{
    constructor(accountNumber, balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    deposit(amount) 
    {
        if (amount > 0) {
            this.balance += amount;
        }
        else {            
            console.log("Deposit amount must be positive.");
        }
    }

    withdraw(amount) 
    {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
        else {
            console.log("Insufficient funds");
        }
    }
}

const acc = new BankAccount('12345', 1000);
acc.deposit(500);
acc.deposit(-100);
acc.withdraw(200);
acc.withdraw(1500);
console.log(`Account Number: ${acc.accountNumber}, Balance: ${acc.balance}`); //