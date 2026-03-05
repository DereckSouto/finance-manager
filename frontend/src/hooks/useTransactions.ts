import { useEffect, useState } from "react";
import type { TransactionResponse } from "../types/TransactionResponse";
import { getAll, getSummary } from "../services/transactionService";

export function useTransactions() {
    const [transactions, setTransactions] = useState<TransactionResponse[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const [balance, setBalance] = useState(0);

    useEffect(() => {
        const load = async () => {
            try {
                setLoading(true);
                setError(null);
                const data = await getAll();
                setTransactions(data);
                const dataSummary = await getSummary();
                setBalance(dataSummary.balance);
            } catch (e) {
                console.error(e);
                setError("Failed to load transactions!")
            } finally {
                setLoading(false);
            }
        };
        load();
    }, []);

    return { transactions, loading, error, balance };
} 
