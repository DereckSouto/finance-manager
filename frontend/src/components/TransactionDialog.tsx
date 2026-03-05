import { Dialog, DialogPanel, DialogTitle } from "@headlessui/react";

type Props = {
    open: boolean;
    onClose: (open: boolean) => void;
};

export function TransactionDialog({ open, onClose }: Props) {
    return (
        <Dialog open={open} onClose={onClose} className="relative z-50">
            <div className="fixed inset-0 bg-black/50" aria-hidden="true" />

            <div className="fixed inset-0 flex items-center justify-center p-4">
                <DialogPanel className="w-full mas-w-lg rounded-2xl bg-white p-4 shadow-xl">
                    <DialogTitle className="text-lg font-semibold">
                        New Transaction
                    </DialogTitle>

                    <div className="mt-4">
                        Test dialog
                    </div>
                </DialogPanel>
            </div>
        </Dialog>
    );
}