package game.controllers;

import game.Command;
import game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameMessages {
    private final Game game;

    @Autowired
    public GameMessages(Game game) {
        this.game = game;
    }

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public ModelAndView index(Model model){
        model.addAttribute("command", new Command());
        return new ModelAndView("index", "game", game);
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public ModelAndView handleCommand(@ModelAttribute Command command, Model model){
        game.parseCommand(command);
        model.addAttribute(game);
        return new ModelAndView("index");
    }

    @RequestMapping("/displayGameMessage")
    @ResponseBody
    public String displayGameMessage() {
        return "Initialize game:";
    }
}
