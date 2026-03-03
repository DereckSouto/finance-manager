export interface TransactionResponse {
    id: number;
    description: string | null;
    amount: number;
    type: "INCOME" | "EXPENSE";
    createdAt: string;
}