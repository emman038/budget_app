import BudgetExpense from "./BudgetExpense";
import IncomeExpense from "./IncomeExpense";
import ReportAnalysis from "./ReportAnalysis";
import Savings from "./Savings";

const Dashboard = () => {
    return ( 
        <>
            <p>Dashboard</p>
            <IncomeExpense/>
            <BudgetExpense/>
            <Savings />
            <ReportAnalysis />
        </>
     );
}
 
export default Dashboard;