export interface SectionProps {
    readonly list: { id: number; text: string; }[];
    readonly searchQuery: string;
    readonly onAddItem: (text: string) => void;
    readonly onDeleteItem: (id: number) => void;
}