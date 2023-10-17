package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("userInfo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Affichage de la List template des utilisateurs
     * @param model Class Model
     * @return la List template des utilisateurs
     */
    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    /**
     * Affichage de la form template d'ajout d'un utilisateur
     * @param user Class Model
     * @return la form template d'ajout d'un utilisateur
     */
    @GetMapping("/user/add")
    public String addUser(User user) {
        return "user/add";
    }

    /**
     * Ajout d'un nouvel utilisateur
     * @param user utilisateur à ajouter
     * @param result validité de l'enregistrement utilisateur à ajouter
     * @param model Calss Model
     * @return la list template des utilisateurs si ajout utilisateur correct, la form template d'ajout d'un utilisateur sinon
     */
    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            model.addAttribute("users", userRepository.findAll());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    /**
     * Affichage de la form template de modification d'un utilisateur
     * @param id de l'utilisateur à modifier
     * @param model Class Model
     * @return la form template de modification d'un utilisateur
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    /**
     * Mise à jour d'un utilisateur
     * @param id du l'utilisateur à modifier
     * @param user contenu du nouvel utilisateur
     * @param result état de l'utilisateur à modifier
     * @param model Class Model
     * @return la template List utilisateur si l'utilisateur en paramètre est valide, la form utilisateur sinon
     */
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/update";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }

    /**
     * Suppression d'un utilisateur
     * @param id de l'utilisateur à supprimer
     * @param model Class Model
     * @return la template list des utilisateur
     */
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }
}
