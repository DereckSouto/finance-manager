import type { TransactionResponse } from "../types/TransactionResponse"

interface TableProps {
    transactions: TransactionResponse[];
}

export default function Table({ transactions }: TableProps) {
    return (
        <table className="w-full border-collapse">
            <thead className="bg-gray-50">
                <tr>
                    <th className="text-left p-3 text-sm font-semibold text-gray-600">ID</th>
                    <th className="text-left p-3 text-sm font-semibold text-gray-600">Description</th>
                    <th className="text-right p-3 text-sm font-semibold text-gray-600">Amount</th>
                    <th className="text-left p-3 text-sm font-semibold text-gray-600">Type</th>
                </tr>
            </thead>
            <tbody>
                {transactions.map((t) => (
                    <tr key={t.id} className="border-t hover:bg-gray-50 transition">
                        <td className="p-3 text-gray-600">{t.id}</td>
                        <td className="p-3 text-gray-600">{t.description ?? "(no description)"}</td>
                        <td className="p-3 text-right font-mono text-gray-600">{new Intl.NumberFormat("pt-BR", {
                            style: "currency",
                            currency: "BRL",
                        }).format(t.amount)}</td>
                        <td className="p-3">
                            <span className={`px-3 py-1 rounded-full text-xs font-semibold text-gray-600 ${t.type === "INCOME"
                                ? "bg-green-100 text-green-700"
                                : "bg-red-100 text-red-700"}`}>
                                {t.type}
                            </span>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}