import { Routes, Route } from "react-router-dom";
import Main from "../../MainArea/Main/Main";
import SongDetails from "../../SongArea/SongDetails/SongDetails";

function Routing(){

    return(<Routes>
        <Route path="/" element={Main}/>
        <Route path="/song/:songid" element={SongDetails}/>
    </Routes>);

}

export default Routing;