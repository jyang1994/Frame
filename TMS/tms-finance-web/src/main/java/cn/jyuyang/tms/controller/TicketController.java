package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketInLog;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.TicketInLogService;
import cn.jyuyang.tms.service.TicketService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/finance/ticket")
public class TicketController {
    @Autowired
    private TicketInLogService ticketInLogService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/in/home")
    public String ticketInHome(Model model) {
        List<TicketInLog> ticketInLogs = ticketInLogService.findAllTicket();
        model.addAttribute("ticketInLogs", ticketInLogs);
        return "ticket/in/home";
    }

    @GetMapping("/in/new")
    public String ticketInNew() {
        return "ticket/in/new";
    }

    @PostMapping("/in/new")
    public String ticketInNew(TicketInLog ticketInLog, RedirectAttributes redirectAttributes) {
        try {
            if (ticketInLog == null) {
                return "ticket/in/new";
            }
            ticketInLogService.saveTicketInlog(ticketInLog);
            return "redirect:/finance/ticket/in/home";
        } catch (ServiceException ex) {

            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return "redirect:/finance/ticket/in/new";
        }

    }

    @GetMapping("/{id:\\d+}/edit")
    public String editTicketInLog(@PathVariable Integer id, Model model) {
        TicketInLog ticketInLog = ticketInLogService.selectById(id);
        model.addAttribute("ticketInLog", ticketInLog);
        return "ticket/in/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    @Transactional(rollbackFor = RuntimeException.class)
    public String editTicketInLog(@PathVariable Integer id, TicketInLog ticketInLog, RedirectAttributes redirectAttributes) {
        try {
            ticketInLogService.deleteTicketInLogAndTicketById(id);

            ticketInLogService.saveTicketInlog(ticketInLog);
            return "redirect:/finance/ticket/in/home";
        } catch (ServiceException ex) {

            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return "redirect:/finance/ticket/in/new";
        }
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delTicketInlog(@PathVariable Integer id) {
        try {
            ticketInLogService.deleteTicketInLogAndTicketById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }

    @GetMapping("/all")
    public String allTicket(@RequestParam(defaultValue = "1",name = "p",required = false) Integer pageNo, Model model){
        PageInfo<Ticket> ticketPageInfo = ticketService.findTicketByPage(pageNo);
        model.addAttribute("ticketPageInfo",ticketPageInfo);
        return "ticket/in/all";
    }
}
