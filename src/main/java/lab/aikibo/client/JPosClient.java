package lab.aikibo.client;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOResponseListener;
import org.jpos.iso.MUX;
import org.jpos.q2.QBeanSupport;
import org.jpos.q2.iso.QMUX;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.util.NameRegistrar;
import org.jpos.util.NameRegistrar.NotFoundException;

public class JPosClient extends QBeanSupport implements ISOResponseListener {
  private Long timeout;
  private Space<String, ISOMsg> responseMap;

  @SuppressWarnings("unchecked")
  @Override
  protected void initService() throws Exception {
    this.timeout = cfg.getLong("timeout");
    this.responseMap = SpaceFactory.getSpace(cfg.get("spaceName"));
    NameRegistrar.register(getName(), this);
  }
}
