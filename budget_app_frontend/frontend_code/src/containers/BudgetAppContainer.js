import LandingPage from "../components/LandingPage";
import Template from "../components/Template";
import AddEntryForm from "../components/addEntryRouteComponents/AddEntryForm";
import Dashboard from "../components/dashboardRouteComponents/dashboardComponents/Dashboard";
import TimeFrame from "../components/dashboardRouteComponents/timeFrameComponents/TimeFrame";
import EditEntryForm from "../components/editEntryRouteComponents/editEntryFormComponents/EditEntryForm";
import SelectEntry from "../components/editEntryRouteComponents/selectEntryComponents/SelectEntry";

const BudgetAppContainer = () => {
    return ( 
        <>
            <p>Container</p>
            <Template />
            <LandingPage/>
            <TimeFrame/> 
            <Dashboard/>
            <AddEntryForm />
            <SelectEntry />
            <EditEntryForm />
        </>
     );
}
 
export default BudgetAppContainer;